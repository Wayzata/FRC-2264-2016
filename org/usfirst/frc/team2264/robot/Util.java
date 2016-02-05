package org.usfirst.frc.team2264.robot;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Util {
	public static final double POLL_TIME = 0.01;
	public static void log(Object o) {
		SmartDashboard.putString("Debug Message", Timer.getFPGATimestamp() + " " + o.toString());
	}
	public static void reportError(Exception ex) {
		SmartDashboard.putString("Error", Timer.getFPGATimestamp() + " " + ex.toString());
	}
	public static void doFor(BooleanSupplier task, double time) {
		double end = Timer.getFPGATimestamp() + time;
		while(Timer.getFPGATimestamp() < end && task.getAsBoolean())
			Timer.delay(POLL_TIME);
	}
	public static void waitUntil(BooleanSupplier condition) {
		while(!condition.getAsBoolean())
			Timer.delay(POLL_TIME);
	}
	public static void waitUntilNot(BooleanSupplier condition) {
		waitUntil(() -> !condition.getAsBoolean());
	}
	public static void doEvery(double time, BooleanSupplier condition) {
		double last;
		boolean cont = true;
		while(cont) {
			last = Timer.getFPGATimestamp();
			cont = condition.getAsBoolean();
			double stopTime = last + time;
			double now = Timer.getFPGATimestamp();
			if(now > stopTime)
				Timer.delay(now - stopTime);
		}
	}
}
