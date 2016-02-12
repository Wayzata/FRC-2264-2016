package org.usfirst.frc.team2264.robot;

import org.usfirst.frc.team2264.robot.subsystems.Arm;
import org.usfirst.frc.team2264.robot.subsystems.Control;
import org.usfirst.frc.team2264.robot.subsystems.Vision;
import org.usfirst.frc.team2264.robot.util.DoubleMotor;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Robot extends IterativeRobot {
	private RobotDrive driveTrain;
	private Control joystick;
	private Vision vision;
	public Arm arm; 
	
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
    	
    	this.arm = new Arm(
    			new CANTalon(RobotParts.MOTORS.SLIDE_MOTOR),
    			new CANTalon(RobotParts.PID_CONTROLLERS.ELBOW),
    			new CANTalon(RobotParts.PID_CONTROLLERS.SHOULDER),
    			new DigitalInput(RobotParts.SWITCHES.EXETEND),
    			new DigitalInput(RobotParts.SWITCHES.RETRACT));
    }
    
    public void teleopPeriodic() {
    	 this.joystick.applyToDrive(this.driveTrain);
    	 this.vision.sendFrame();
    	 
    	 
    }
    
}
