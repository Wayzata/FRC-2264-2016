package org.usfirst.frc.team2264;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;

public class DoubleMotor implements SpeedController {
	CANTalon front;
	CANTalon rear;
	
	public DoubleMotor(CANTalon front, CANTalon rear) {		
		this.front = front;
		this.rear = rear;
	
	}

	@Override
	public void pidWrite(double output) {
		this.front.pidWrite(output);
		this.rear.pidWrite(output);	
	}

	@Override
	public double get() {
		return front.getSpeed();
	
	}

	@Override
	public void set(double speed, byte syncGroup) {
		this.front.set(speed, syncGroup);
		this.rear.set(speed, syncGroup);
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
		return front.getInverted();
		
	}

	@Override
	public void disable() {
		this.front.disable();
		this.rear.disable();
	}

}
