/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.RobotDrive;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  public WPI_TalonSRX driveTrainLeftFrontMotor;
  public WPI_TalonSRX driveTrainRightFrontMotor;
  public WPI_TalonSRX driveTrainLeftRearMotor;
  public WPI_TalonSRX driveTrainRightRearMotor;
  
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  public RobotMap(){
    driveTrainLeftFrontMotor = new WPI_TalonSRX(15);
    driveTrainRightFrontMotor = new WPI_TalonSRX(14);
    driveTrainLeftRearMotor = new WPI_TalonSRX(16);
    driveTrainRightRearMotor = new WPI_TalonSRX(13);
   
     
  }
}
