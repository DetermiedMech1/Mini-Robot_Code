// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class MotorConstants {
    public static final int kLeftMotorID = 1;
    public static final int kRightMotorID = 2;
  }
  public static class Deadzone {
    public static final double kRTDeadzone = 0.5;
    public static final double kLSDeadzone = 0.5;
    public static final double kRSDeadzone = 0.5;
    public static final double kLTDeadzone = 0.5;
  }
  public class LimeLightConstants {
    public static final double kLLHeight = 0.0;
    public static final double kObjectHeight = 0.0;
    public static final double kLLPitch = 0.0;
  }
}
