package org.usfirst.frc.team2869.robot.commands;

import org.usfirst.frc.team2869.robot.subsystems.CubeLift;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftCube extends Command {
	DoubleSolenoid armCylinder = new DoubleSolenoid(6,7);    	

    public LiftCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	CubeLift.toggleCylinders();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		armCylinder.set(DoubleSolenoid.Value.kForward);    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		armCylinder.set(DoubleSolenoid.Value.kReverse);      	
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
