package org.usfirst.frc.team2264.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//refer to the class as just joystick
public class Control {
	private Joystick joystick;
	private Joystick gamepad;
	// divider must be over 2.0
	private final double DIVIDER = 2.0;
//divider = 2.0, there so you can change one number and easily change all the numbers called dividers, 
	//final so it can't change when the program is running
	
	//Creates/Initializing a new joystick
	public Control(){
		this.joystick = new Joystick(0);
		this.gamepad = new Joystick(1);
		
}
	//gets the axis of the joystick (x, y, and z values)
	public void applyToDrive(RobotDrive drive){
		double x = this.joystick.getX();
		double y = this.joystick.getY();
		double z = this.joystick.getZ();
		double twist = this.joystick.getTwist();
		
		//setting the speed of the moving and turning of the robot!
		double move = y * (z + 1.0) / DIVIDER;
		double turn = x * (z + 1.0) / DIVIDER;
	
		//Turbo Button
		if (!this.joystick.getRawButton (1)){
			move = move/2;	
		}
		
		//Type of mechanical set up that our robot has (I dont know at all)
		drive.arcadeDrive(move, turn);
	}

	public void applyToArm(Arm arm) {//set speeds later
		double Lx = this.gamepad.getRawAxis(0);
		double Rx = this.gamepad.getRawAxis(4);
		double Ly = this.gamepad.getRawAxis(1);
		double Ry = this.gamepad.getRawAxis(5);
		int pov = this.gamepad.getPOV(0);
		//for mapping pov to the top of the dpad
		if ((this.gamepad.getPOV(0) < 90) || (this.gamepad.getPOV(0) > 270)){
			arm.slideMotor.set(.5);
		}else if ((this.gamepad.getPOV(0) > 90) && (this.gamepad.getPOV(0) < 270)){
			arm.slideMotor.set(-.5);	
		}else{ 
			arm.slideMotor.set(0);
		}
		//safety switches
		//TODO
		//elbow and shoulder (trig?)
		//TODO
		
		}
	}




