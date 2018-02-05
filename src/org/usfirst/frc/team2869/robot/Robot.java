
package org.usfirst.frc.team2869.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2869.robot.commands.BaselineAutonomous;
import org.usfirst.frc.team2869.robot.commands.DoNothingAuto;
import org.usfirst.frc.team2869.robot.commands.DriveForward;
//import org.usfirst.frc.team2869.robot.commands.LeftCornerAutonomous;
//import org.usfirst.frc.team2869.robot.commands.MiddleAutonomous;
//import org.usfirst.frc.team2869.robot.commands.MoveClimber;
//import org.usfirst.frc.team2869.robot.commands.MoveRamp;
//import org.usfirst.frc.team2869.robot.commands.ReverseLift;
////import org.usfirst.frc.team2869.robot.commands.SpinClimber;
//import org.usfirst.frc.team2869.robot.commands.SpinIntake;
//import org.usfirst.frc.team2869.robot.commands.SpinLift;
//import org.usfirst.frc.team2869.robot.commands.SpinRoller;
//import org.usfirst.frc.team2869.robot.commands.SpinShooter;
import org.usfirst.frc.team2869.robot.subsystems.DriveTrain;

//import com.ctre.CANTalon.TalonControlMode;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain driveTrain;
	public static double moveValue, rotateValue;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	//private static CameraServer camera;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void robotInit() {
		SmartDashboard.putNumber("Degrees", 0);
		oi = new OI();
		driveTrain = new DriveTrain();
	//	compressorSwitch = new Comp ressorSwitch();
//		OI.driverJoystick.GetBButton().whenActive(new SpinLift());
//		OI.driverJoystick.GetRightBumper().whenActive(new SpinRoller());
//		OI.driverJoystick.GetBackButton().whenActive(new ReverseLift());
//		OI.driverJoystick.GetBButton().whenActive(new MoveClimber());

		//OI.driverJoystick.GetLeftBumper().whenActive(new TiltIntakeUp());
		//OI.driverJoystick.GetRightBumper().whenActive(new TiltIntakeDown());
		
//		OI.driverJoystick.GetAButton().whenActive(new SpinClimber());
//		OI.operatorJoystick.GetBButton().whenActive(new MoveRamp());
//		OI.operatorJoystick.GetBackButton().whenActive(new DisableCompressor());
//		OI.operatorJoystick.GetLeftBumper().whenActive(new TiltIntakeUp());
//		OI.operatorJoystick.GetRightBumper().whenActive(new TiltIntakeDown());
	//	SmartDashboard.putDouble("P", .00005);
		//SmartDashboard.putDouble("I", 0);
		//SmartDashboard.putDouble("D", 0);
		//camera = CameraServer.getInstance();
		//camera.startAutomaticCapture().setResolution(256, 256);
		
		SmartDashboard.putData("Auto chooser", chooser);
		//chooser.addObject("LeftCorner Autonomous", new LeftCornerAutonomous());
		//chooser.addObject("Middle Autonomous", new MiddleAutonomous());
		//chooser.addObject("RightCorner Autonomous", new RightCornerAutonomous());
		//chooser.addObject("Baseline Autonomous", new BaselineAutonomous());
		
//		driveTrain.leftMotor2.changeControlMode(TalonControlMode.Follower);
	//	driveTrain.leftMotor2.set(driveTrain.leftMotor1.getDeviceID());
//		driveTrain.rightMotor2.changeControlMode(TalonControlMode.Follower);
		//driveTrain.rightMotor2.set(driveTrain.rightMotor1.getDeviceID());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		if(autonomousCommand!=null)
			if(autonomousCommand.isRunning())
				autonomousCommand.cancel();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	
	/**
	 * class NAVX
	 * left setpoint .8 + (angle difference)*0.01
	 * right setpoint .8 - (angle difference)*0.01;
	 * 
	 */
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L')
		{
			autonomousCommand = new BaselineAutonomous();
			
		} else {
			autonomousCommand = new DoNothingAuto();
			}
		
		

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
		
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		autonomousCommand = new BaselineAutonomous();
//		String gameData;
//		gameData = DriverStation.getInstance().getGameSpecificMessage();
//		if(gameData.charAt(0) == 'L')
//		{
//			new DriveForward(-.8,-10);
//		} else {
//			new DriveForward(-.8,-10);
//		}
//		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//driveTrain.drive.arcadeDrive(OI.driverJoystick.GetAllTriggers(), OI.driverJoystick.GetLeftX());
		//System.out.println(OI.driverJoystick.getPort());
		//shooter.pid.setPID(SmartDashboard.getDouble("P"), SmartDashboard.getDouble("I"),
			//	SmartDashboard.getDouble("D"));
		SmartDashboard.putNumber("Yaw", driveTrain.gyro.getYaw());
		
		
		//This might change the speed of the motors.
		driveTrain.drive.arcadeDrive(OI.driverJoystick.GetAllTriggers(), -OI.driverJoystick.GetLeftX());
		
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
