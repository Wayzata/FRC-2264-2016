package org.usfirst.frc.team2264.robot.subsystems;

import org.usfirst.frc.team2264.robot.RobotParts;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;

public class Arm {
	CANTalon slideMotor;
	DigitalInput extendSwitch;
	DigitalInput retractSwitch;
	

	public Arm(int slideMotorID, int extendSwitchID, int retractSwitchID){
		this.slideMotor = new CANTalon(slideMotorID);
		this.extendSwitch = new DigitalInput(extendSwitchID);
		this.retractSwitch = new DigitalInput(retractSwitchID);
		

	}

	public void extendForearm(){
		if (this.extendSwitch.get()){
			this.stopForearm();
		}else{
			this.slideMotor.set(.5);
		}
	}

	public void retractForearm(){
		if (this.retractSwitch.get()){
			this.stopForearm();
		}else{
			this.slideMotor.set(-.5);
		}

	}

	public void stopForearm(){
		this.slideMotor.set(0);

	}


}
