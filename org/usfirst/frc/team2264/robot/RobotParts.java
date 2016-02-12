package org.usfirst.frc.team2264.robot;

public class RobotParts {
	public static class MOTORS {
		public static final int LEFT_FRONT = 17;
		public static final int LEFT_REAR = 20;
		public static final int RIGHT_FRONT = 18;
		public static final int RIGHT_REAR = 19;
		public static final int SLIDE_MOTOR = 26;
		
		public static final int SHOULDER = 24;
		public static final int ELBOW = 25;
		
		public static final int SHOOTER_BELT = 21;
		public static final int SHOOTER_ARM = 23;
		public static final int SHOOTER_MAIN = 22;
	}
	public static class SWITCHES {
		public static final int EXETEND = 0;
		public static final int RETRACT = 1;
	}
	
	public static class PID_CONTROLLERS {
		public static final int SHOULDER = 24;
		public static final int ELBOW = 25;
		public static final double Kp = 1;
		public static final double Ki = 0;
		public static final double Kd = 0;
	}
}
