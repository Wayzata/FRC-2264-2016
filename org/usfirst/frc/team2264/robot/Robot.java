package org.usfirst.frc.team2264.robot;

import org.usfirst.frc.team2264.robot.subsystems.Control;
import org.usfirst.frc.team2264.robot.subsystems.Vision;
import org.usfirst.frc.team2264.robot.util.DoubleMotor;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Robot extends IterativeRobot {
	private RobotDrive driveTrain;
	private Control joystick;
	private Vision vision;
	
    public void robotInit() {
    	this.driveTrain = new RobotDrive(
    		new DoubleMotor(
	    		new CANTalon(RobotParts.MOTORS.LEFT_FRONT),	
	    		new CANTalon(RobotParts.MOTORS.LEFT_REAR)
	    	),
    		new DoubleMotor(
	    		new CANTalon(RobotParts.MOTORS.RIGHT_FRONT),
	    		new CANTalon(RobotParts.MOTORS.RIGHT_REAR)
	    	)
    	);
    	this.joystick = new Control();
    	this.vision = new Vision("cam0");
    }
    public void teleopPeriodic() {
    	 this.joystick.setDrive(this.driveTrain);
    	 this.vision.sendFrame();
    }
}
