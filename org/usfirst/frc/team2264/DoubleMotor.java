package org.usfirst.frc.team2264;

import org.usfirst.frc.team2264.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
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
		this.pidWrite(get());	
	}

	@Override
	public double get() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set(double speed, byte syncGroup) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void set(double speed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInverted(boolean isInverted) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getInverted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub

	}

}
