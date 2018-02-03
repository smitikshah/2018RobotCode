package org.usfirst.frc.team2869.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BaselineAutonomous extends CommandGroup {

    public BaselineAutonomous() {
    	new Drive(1);
    }
}
