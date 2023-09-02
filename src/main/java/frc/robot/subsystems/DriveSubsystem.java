// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenixpro.hardware.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  public WPI_VictorSPX leftMotor;
  public WPI_VictorSPX rightMotor;
  public DifferentialDrive drive;

  public DriveSubsystem() {
    leftMotor = new WPI_VictorSPX(Constants.MotorConstants.kLeftMotorID);
    rightMotor = new WPI_VictorSPX(Constants.MotorConstants.kRightMotorID);

    leftMotor.configOpenloopRamp(0.25);
    rightMotor.configOpenloopRamp(0.25);
    
    leftMotor.setInverted(true);
    rightMotor.setInverted(false);

    drive = new DifferentialDrive(leftMotor, rightMotor);
  }

  public void driveRobot(double throttle, double turn) {
    drive.arcadeDrive(throttle, turn);
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
