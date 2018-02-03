package org.usfirst.frc.team2869.robot.subsystems;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team2869.robot.GyroScope;
import org.usfirst.frc.team2869.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
public class DriveTrain extends Subsystem {
	
	public RobotDrive drive = new RobotDrive(new WPI_TalonSRX(RobotMap.leftMotor1), new WPI_TalonSRX(RobotMap.rightMotor1),
			new WPI_TalonSRX(RobotMap.leftMotor2), new WPI_TalonSRX(RobotMap.rightMotor2));
	
	public GyroScope gyro = new GyroScope();
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

