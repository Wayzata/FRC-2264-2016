package org.usfirst.frc.team2264.robot.subsystems;
 
import edu.wpi.first.wpilibj.CANTalon;
import org.usfirst.frc.team2264.robot.RobotParts;

/**
 * The controlling class for the Shooter
 * @author mariel
 */
 public class Shooter {

	

	private CANTalon mainMotor;
	private CANTalon beltMotor;
	private CANTalon armMotor;

	/**
	 * Constructs the various shooter motors
	 */
	public Shooter() {
		this.mainMotor = new CANTalon(RobotParts.MOTORS.SHOOTER_MAIN);
		this.beltMotor = new CANTalon(RobotParts.MOTORS.SHOOTER_BELT);
		this.armMotor = new CANTalon(RobotParts.MOTORS.SHOOTER_ARM);
	}

	/**
	 * raises the arm
	 */
	public void raiseArm() {
		this.armMotor.set(1);
	}

	/**
	 * lowers the arm
	 */
	public void lowerArm() {
		this.armMotor.set(-1);
	}

	/**
	 * Pauses and stops the arm from moving
	 */
	public void stopArm() {
		this.armMotor.set(0);
	}

	/**
	 * This either goes counter cw or ccw, i am unsure
	 */
	public void pullBelt() {
		this.beltMotor.set(1);
	}

	/**
	 * This either goes counter cw or ccw, i am unsure
	 */
	public void pushBelt() {
		this.beltMotor.set(-1);
	}

	/**
	 * pauses the belt motor
	 */
	public void stopBelt() {
	this.beltMotor.set(0);
	}

	/**
	 * main motor in robot shooter spins and shoots the ball
	 */
 	public boolean shoot() {

		this.mainMotor.set(.5);

 		// TODO
 		return false;
 	}
 }