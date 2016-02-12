package org.usfirst.frc.team2264.robot.util;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Preeti and Gwyneth
 */

//sets the front and rear motor and sets them to front and rear respectively
public class DoubleMotor implements SpeedController {
	CANTalon front;
	CANTalon rear;
	//
	public DoubleMotor(CANTalon front, CANTalon rear) {		
		this.front = front;
		this.rear = rear;
	
	}
	//Writes the same output from both front and rear motors.
	@Override
	public void pidWrite(double output) {
		this.front.pidWrite(output);
		this.rear.pidWrite(output);
	}

	@Override
	public double get() {
		return this.front.get();
	}
	//Sets motors at the same speed and gives them the same syncGroup.
	@Override
	public void set(double speed, byte syncGroup) {
		this.front.set(speed, syncGroup);
		this.rear.set(speed, syncGroup);
		SmartDashboard.putNumber("set()", speed);
	}
	//@Override = changes made to a class in small increments 
	//sets the front and rear motors to the same speed
	@Override
	public void set(double speed) {
		this.front.set(speed);
		this.rear.set(speed);
	}
	//if the motors are inverted they will still go the same speed
	@Override
	public void setInverted(boolean isInverted) {
		this.front.setInverted(isInverted);
		this.rear.setInverted(isInverted);
	}
	//gets the return from the front motor and only front because both motors are the same speed
	@Override
	public boolean getInverted() {
		return this.front.getInverted();
	}
	//This disables the motors
	@Override
	public void disable() {
		this.front.disable();
		this.rear.disable();
	}
}
