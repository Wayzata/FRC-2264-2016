package org.usfirst.frc.team2264.robot.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ImageType;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * Manages vision for the robot.
 * @author Nathan Ringo
 */
public class Vision {
	private Image cameraFrame;
	private USBCamera camera;
	
	/**
	 * Initializes a camera based on its name.
	 * @param cameraName The camera's name.
	 */
	public Vision(String cameraName) {
		this.cameraFrame = NIVision.imaqCreateImage(ImageType.IMAGE_RGB, 0);
		this.camera = new USBCamera(cameraName);
		this.camera.openCamera();
		this.camera.startCapture();
		this.camera.setWhiteBalanceAuto();
		this.camera.setExposureAuto();
	}

	/**
	 * Sends a frame from the camera to the SmartDashboard.
	 */
	public void sendFrame() {
		this.camera.getImage(this.cameraFrame);
		CameraServer.getInstance().setImage(this.cameraFrame);
	}
}
