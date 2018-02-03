package org.usfirst.frc.team2869.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeLift extends Subsystem {
	public static DoubleSolenoid armCylinder = new DoubleSolenoid(0, 1);
	private static Value isActivated = armCylinder.get();
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static void toggleCylinders(){
		if(isActivated == DoubleSolenoid.Value.kForward){
			armCylinder.set(DoubleSolenoid.Value.kForward);
			
		} else {
			armCylinder.set(DoubleSolenoid.Value.kOff);
		}
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

