/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2438.robot.subsystems;

import org.usfirst.frc.team2438.robot.RobotMap;
import org.usfirst.frc.team2438.robot.commands.OperateLift;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;


import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Lift extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private static final double WHEEL_DIAMETER_INCHES  = 1.5;
	private static final double WHEEL_INCHES_PER_REV   = Math.PI * WHEEL_DIAMETER_INCHES;
	private static final double GEAR_BOX_RATIO         = 10; // TODO - Check
	private static final double ENCODER_TICKS_PER_REV  = 1024 * GEAR_BOX_RATIO * 4;
	private static final double ENCODER_INCHES_PER_REV = ENCODER_TICKS_PER_REV / WHEEL_INCHES_PER_REV;

	private TalonSRX _lift;
	
	public void init() {
		_lift = new TalonSRX(RobotMap.lift);
		_lift.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    	_lift.setSelectedSensorPosition(0, 0, 0);
	
    	_lift.configNominalOutputForward(0, 0);
    	_lift.configNominalOutputReverse(0, 0);
    	_lift.configPeakOutputForward(1, 0);
    	_lift.configPeakOutputReverse(-1, 0);
    	
    	_lift.selectProfileSlot(0, 0);
    	_lift.config_kF(0, 0, 0);
    	_lift.config_kP(0, 0, 0);
    	_lift.config_kI(0, 0, 0);
    	_lift.config_kD(0, 0, 0);
    	_lift.config_IntegralZone(0, 0, 0);
    	_lift.configMotionAcceleration(256, 0);
    	_lift.configMotionCruiseVelocity(1024, 0);
    	_lift.set(ControlMode.MotionMagic, 0);
	}
	
	public void setPower(double power) {
		_lift.set(ControlMode.PercentOutput, power);
	}
	
	public void setPosition(double inches) {
		_lift.set(ControlMode.MotionMagic, inches*ENCODER_INCHES_PER_REV);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new OperateLift());
	}
}
