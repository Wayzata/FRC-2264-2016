package org.usfirst.frc.team2264.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;

/**
 * @author Drake and Kushal 
 */
public class Winch {
	CANTalon winder;
	long startTime;
	long movingTime;
	long lastUpdate;
	final long oneSecond = (1000000000);
	public Winch(CANTalon winder){
		this.winder = winder;
	}
	public void set(double speed){
		this.winder.set(speed);
	}
	public void stopWinding(){
		this.set(0);
	}
	public void startWinding(double speed){
		
		if (speed > 0){
			this.set(speed);
		}
	}
	public void startUnwinding(double speed){
		if (speed < 0){
			this.set(speed);
		}
	}
	public void Update(){
		long currentTime = System.nanoTime();
		long elapsedTime = (currentTime - this.lastUpdate);
		
		if(this.winder.get() > 0){
			this.movingTime += elapsedTime;
		}
		else if (this.winder.get() < 0){
			this.movingTime -= elapsedTime;
		}
		
		if ((this.movingTime >= (5*this.oneSecond)) || (this.movingTime <= 0)){
			this.stopWinding();
		}
		this.lastUpdate = currentTime;
	}
}
