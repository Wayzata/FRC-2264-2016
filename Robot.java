package xyz.remexre.robotics.frc2016;

import java.util.HashSet;
import java.util.Set;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import xyz.remexre.robotics.frc2016.autonomous.ArmDownAutonomous;
import xyz.remexre.robotics.frc2016.autonomous.AutonomousProgram;
import xyz.remexre.robotics.frc2016.autonomous.BasicAutonomous;
import xyz.remexre.robotics.frc2016.controls.ControlScheme;
import xyz.remexre.robotics.frc2016.controls.Controls;
import xyz.remexre.robotics.frc2016.controls.GamepadButton;
import xyz.remexre.robotics.frc2016.controls.schemes.ChloeMarcusControlScheme;
import xyz.remexre.robotics.frc2016.controls.schemes.DrakeGwynethControlScheme;
import xyz.remexre.robotics.frc2016.modules.Controllers;
import xyz.remexre.robotics.frc2016.modules.DriveTrain;
import xyz.remexre.robotics.frc2016.modules.Module;
import xyz.remexre.robotics.frc2016.modules.Shooter;
import xyz.remexre.robotics.frc2016.util.BetterSendableChooser;

public class Robot extends IterativeRobot {
	private BetterSendableChooser<AutonomousProgram> autonomi;
	private long autonomousStartTime;
	private CameraServer cameraServer;
	private Controllers controllers;
	private BetterSendableChooser<ControlScheme> controlSchemes;
	private Set<Module> modules;
	
	public Robot() {
        cameraServer = CameraServer.getInstance();
        cameraServer.setQuality(50);
        cameraServer.startAutomaticCapture("cam0");
    }
	
	@Override
	public void robotInit() {
		this.autonomi = new BetterSendableChooser<>("Autonomous Programs",
				new BasicAutonomous(),
				new ArmDownAutonomous());
		
		this.controllers = new Controllers(RobotParts.JOYSTICKS.DRIVE,
				RobotParts.JOYSTICKS.ARM);
		
		this.controlSchemes = new BetterSendableChooser<>("Control Schemes",
				new ChloeMarcusControlScheme(),
				new DrakeGwynethControlScheme());

		this.modules = new HashSet<>();
		this.modules.add(new DriveTrain(
				RobotParts.MOTORS.FRONT_LEFT,
				RobotParts.MOTORS.BACK_LEFT,
				RobotParts.MOTORS.FRONT_RIGHT,
				RobotParts.MOTORS.BACK_RIGHT));
		this.modules.add(new Shooter(
				RobotParts.MOTORS.SHOOTER,
				RobotParts.MOTORS.BELT,
				RobotParts.MOTORS.SHOOTER_ARM));
		
		this.modules.forEach((module) -> module.reset());
	}
	
	@Override
	public void autonomousInit() {
		this.autonomousStartTime = System.currentTimeMillis();
	}
	
	@Override
	public void autonomousPeriodic() {
		long timeInAutonomous = System.currentTimeMillis() - this.autonomousStartTime;
		Controls controls = this.autonomi.get().periodic(timeInAutonomous);
		this.modules.forEach((module) -> module.control(controls));
	}

	@Override
	public void teleopPeriodic() {
		// Get the gamepad controls.
		ControlScheme controlScheme = this.controlSchemes.get();
		Set<GamepadButton> buttons = this.controllers.getGamepadButtons(controlScheme);
		Controls controls = controlScheme.map(buttons,
				this.controllers.getDriveAxes(),
				this.controllers.getSlider(),
				this.controllers.getLeftAxes(),
				this.controllers.getRightAxes());
		controls.debug();

		// Send state to the modules.
		this.modules.forEach((module) -> module.control(controls));
	}
}
