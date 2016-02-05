package org.usfirst.frc.team2264.robot;

import org.usfirst.frc.team2264.robot.util.DoubleMotor;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Robot extends IterativeRobot {
	private Joystick joystick;
	private RobotDrive drive;
	
    public void robotInit() {
    	this.joystick = new Joystick(0);
    	this.drive = new RobotDrive(
    		new DoubleMotor(new CANTalon(19), new CANTalon(18)),
    		new DoubleMotor(new CANTalon(20), new CANTalon(17))
    	);
    }
    public void teleopPeriodic() {
    	this.drive.arcadeDrive(this.joystick);
    }
}
