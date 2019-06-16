/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PIDDrive extends Command {

  double power;
  double targetDistance;
  double currentDistance = 0;
  double error;
  double oldError;
  double totalError = 0;
  double kP = 0;
  double kI = 0;
  double kD = 0;


  public PIDDrive(double _targetDistance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_driveTrain);
    this.targetDistance = _targetDistance;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_encoder.zeroEncoder();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    currentDistance = Robot.m_encoder.getEncoderPosition();
    error = targetDistance-currentDistance;
    totalError += error;
    power = (kP*error+(kD*(error-oldError))+(kI*totalError));

    if(power>1) 
    {
      power=1;
    }
    else if(power<-1)
    {
        power=-1;
    }

    Robot.m_driveTrain.autonomousDrive(power);

    oldError = error;

  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(currentDistance == targetDistance){

      return true;

    }
    else {
      
      return false;
    }
    
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.m_driveTrain.autonomousDrive(0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    end();

  }
}
