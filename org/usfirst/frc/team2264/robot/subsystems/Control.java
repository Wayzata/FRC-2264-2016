package org.usfirst.frc.team2264.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Control {
	private Joystick joystick;

	
	public Control(){
		this.joystick = new Joystick(1);
}
	
	public void setDrive(RobotDrive drive){
		double x = this.joystick.getX();
		double y = this.joystick.getY();
		double z = this.joystick.getZ();
		double twist = this.joystick.getTwist();
		
			
		double move = y * (z + 1.0) / 2.0;
		double turn = x * (z + 1.0) / 2.0;
	
		if (!this.joystick.getRawButton (1)){
			move = move/2;
			
			
		}
		drive.arcadeDrive(move, turn);
		

	}

}
