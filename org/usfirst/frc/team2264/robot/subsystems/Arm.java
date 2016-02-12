package org.usfirst.frc.team2264.robot.subsystems;

import org.usfirst.frc.team2264.robot.RobotParts;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

//Declares The CANTalon and the Switches
public class Arm {
	//top part of arm
	CANTalon slideMotor;
	DigitalInput extendSwitch;
	DigitalInput retractSwitch;
	double shoulderGoalAngle = 0.0;
	double elbowGoalAngle = 0.0;
	
	//bottom of the arm
	CANTalon shoulderMotor;
	CANTalon elbowMotor;
	
	Joystick joystick;
	
	//Initializing and setting the values for the slideMotor and extend/retract Switch
	
	public Arm(CANTalon slideMotor, CANTalon elbowMotor, CANTalon shoulderMotor, DigitalInput extendSwitch,
			DigitalInput retractSwitch) {
		// TODO Auto-generated constructor stub
		this.shoulderMotor.changeControlMode(TalonControlMode.Position);
		this.shoulderMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		this.shoulderMotor.setPID(1, 0, 0);
		this.elbowMotor.changeControlMode(TalonControlMode.Position);
		this.elbowMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		this.shoulderMotor.setPID(1, 0, 0);
	}
	//Extending the Forearm and tells when the switch is triggered and when to stop extending
	public void extendForearm(){
		if (this.extendSwitch.get()){
			this.stopForearm();
		}else{
			this.slideMotor.set(.5);
		}
	}
// tells when the retract switch is triggered and when to stop retracting 
	public void retractForearm(){
		if (this.retractSwitch.get()){
			this.stopForearm();
		}else{
			this.slideMotor.set(-.5);
		}

	}
//stops the extension or retraction and sets the slidemotor speed to 0
	public void stopForearm(){
		this.slideMotor.set(0);
	}
	
//moving halfTilt motor
	public void elbowDown(){
		this.elbowMotor.set(-.5);
	}
	public void elbowUp() {
		this.elbowMotor.set(.5);
	}
	public void elbowStop() {
		this.elbowMotor.set(0);
	}
	
	//moving wholeTilt motor
	public void shoulderDown(){
		this.shoulderMotor.set(-.5);
	}
	public void shoulderUp() {
		this.shoulderMotor.set(.5);
	}
	public void shoulderStop(){
		this.shoulderMotor.set(0);
	}
}
