package org.usfirst.frc.team2438.robot.commands;

import org.usfirst.frc.team2438.robot.OI;
import org.usfirst.frc.team2438.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2438.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	public static OI oi = new OI();
	public static Lift lift = new Lift();
	public static Drivetrain drivetrain = new Drivetrain();
	
	public static void init() {
		lift.init();
	}
}
