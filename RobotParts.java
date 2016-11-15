package xyz.remexre.robotics.frc2016;

/**
 * RobotParts is a class of constants for part IDs.
 * @author Nathan Ringo
 */
public class RobotParts {
	/**
	 * The ID numbers of the USB joysticks.
	 * @author Nathan Ringo
	 */
	public static final class JOYSTICKS {
		public static final int DRIVE = 0;
		public static final int ARM = 1;
	}

	/**
	 * The ID numbers of the CANTalons.
	 * @author Nathan Ringo
	 */
	public static final class MOTORS {
		public static final int FRONT_LEFT = 17;
		public static final int FRONT_RIGHT = 18;
		public static final int BACK_LEFT = 20;
		public static final int BACK_RIGHT = 19;

		public static final int BELT = 21;
		public static final int SHOOTER_ARM = 23; // TODO SAFETY
		public static final int SHOOTER = 22;
	}
	
	/**
	 * The axis numbers on the joystick and gamepad.
	 */
	public static final class AXES {
		public static final int JOYSTICK_X = 0;
		public static final int JOYSTICK_Y = 1;
		public static final int JOYSTICK_TWIST = 2;
		public static final int JOYSTICK_SLIDER = 3;

		public static final int GAMEPAD_LEFT_X = 0;
		public static final int GAMEPAD_LEFT_Y = 1;
		public static final int GAMEPAD_RIGHT_X = 4;
		public static final int GAMEPAD_RIGHT_Y = 5;
		public static final int GAMEPAD_L2 = 2;
		public static final int GAMEPAD_R2 = 3;
	}
}
