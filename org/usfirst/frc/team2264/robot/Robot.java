package org.usfirst.frc.team2264.robot;

import org.usfirst.frc.team2264.Winch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot {
	private Joystick joystick;
	private Winch winch;
	
    public void robotInit() {
    	this.joystick = new Joystick(0);
    	this.winch = new Winch(new CANTalon(18));
    }
    public void teleopPeriodic() {
    	int pov = this.joystick.getPOV();
    	if(pov == 0)
    		this.winch.startWinding(1.0);
    	else if(pov == 180)
    		this.winch.startUnwinding(1.0);
    	else this.winch.stopWinding();
    	this.winch.Update();
    }
}
