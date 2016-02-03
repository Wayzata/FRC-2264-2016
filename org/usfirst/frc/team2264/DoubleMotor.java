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
	//Writes the same output from both front and rear motors.
	@Override
	public void pidWrite(double output) {
		this.front.pidWrite(output);
		this.rear.pidWrite(output);
	}

	@Override
	public double get() {
		// TODO Auto-generated method stub
		return 0;
	}
	//Sets motors at the same speed and gives them the same syncGroup.
	@Override
	public void set(double speed, byte syncGroup) {
		this.front.set(speed, syncGroup);
		this.rear.set(speed, syncGroup);

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
