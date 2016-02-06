package org.usfirst.frc.team2264.robot.util;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Preeti and Gwyneth
 */
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

	@Override
	public void set(double speed) {
		this.front.set(speed);
		this.rear.set(speed);
	}

	@Override
	public void setInverted(boolean isInverted) {
		this.front.setInverted(isInverted);
		this.rear.setInverted(isInverted);
	}

	@Override
	public boolean getInverted() {
		return this.front.getInverted();
	}

	@Override
	public void disable() {
		this.front.disable();
		this.rear.disable();
	}
}
