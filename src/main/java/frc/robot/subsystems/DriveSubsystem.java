// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  public WPI_TalonSRX leftMotor;
  public WPI_TalonSRX rightMotor;
  public DifferentialDrive drive;
  public LimeLight limeLight;

  public DriveSubsystem() {
    leftMotor = new WPI_TalonSRX(Constants.MotorConstants.kLeftMotorID);
    rightMotor = new WPI_TalonSRX(Constants.MotorConstants.kRightMotorID);


    /*
     * this method is used to limit the speed it takes to go from 0-100% speed
     * here it is set to 0.25 seconds
    */
    leftMotor.configOpenloopRamp(0.25);
    rightMotor.configOpenloopRamp(0.25);

    leftMotor.enableVoltageCompensation(true);
    rightMotor.enableVoltageCompensation(true);

    leftMotor.setInverted(true);
    rightMotor.setInverted(false);


    drive = new DifferentialDrive(leftMotor, rightMotor);

    limeLight = new LimeLight();
  }

  /* 
   * this function uses the .arcadeDrive method
   * to move the robot like a tank
  */
  public void driveRobot(double throttle, double turn) {
    drive.arcadeDrive(throttle, turn);
  }

  public void trackObject() {
    if (limeLight.getXAngle() != 0 && Math.abs(limeLight.getXAngle()) >= 1) {
      double speed = 0.03; // between 0 and 1
      double direction = (-limeLight.getXAngle()) / Math.abs(limeLight.getXAngle());
      double scaleFactor = (Math.abs(limeLight.getXAngle())) * speed;
      SmartDashboard.putNumber("tracking velocity", direction * scaleFactor);
      if (scaleFactor > 2) {
        scaleFactor = 1.4;
      }
      System.out.println("direction: "+direction+" scale: "+scaleFactor);
      driveRobot(0, 1);
    }
    
    driveRobot(0, 0);
         
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
