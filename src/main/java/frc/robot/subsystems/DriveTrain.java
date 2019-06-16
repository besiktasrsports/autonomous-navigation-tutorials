/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.xboxDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public RobotDrive robotDrive;
  public DriveTrain(){
    robotDrive = new RobotDrive(Robot.m_robotMap.driveTrainLeftFrontMotor,
    Robot.m_robotMap.driveTrainLeftRearMotor, Robot.m_robotMap.driveTrainRightFrontMotor, Robot.m_robotMap.driveTrainRightRearMotor);
      robotDrive.setSafetyEnabled(false);
      robotDrive.setSensitivity(0.5);
      robotDrive.setExpiration(0.1);
      robotDrive.setMaxOutput(1.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    Robot.m_driveTrain.setDefaultCommand(new xboxDrive());
  }
  public void driveBase(){
    robotDrive.arcadeDrive(Robot.m_oi.xbox.getX(), Robot.m_oi.xbox.getY());
  }

  public void autonomousDrive(double speed){
    Robot.m_robotMap.driveTrainLeftFrontMotor.set(speed);
    Robot.m_robotMap.driveTrainLeftRearMotor.set(speed);
    Robot.m_robotMap.driveTrainRightFrontMotor.set(-speed);
    Robot.m_robotMap.driveTrainRightRearMotor.set(-speed);
  }
  
}
