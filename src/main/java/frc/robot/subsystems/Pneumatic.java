/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Pneumatic extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public DoubleSolenoid doubleSolenoid;
  public Compressor compressor;
  public Pneumatic(){
    doubleSolenoid = new DoubleSolenoid(0, 1, 2);
    compressor = new Compressor(0);
  }
  public void forwardPistons(){
    doubleSolenoid.set(Value.kForward);
  }
  public void reversePistons(){
    doubleSolenoid.set(Value.kReverse);
  }
  public void pistonsOff(){
    doubleSolenoid.set(Value.kOff);
  }
  public void openCompressor(){
    compressor.setClosedLoopControl(true);
  }
  public void closeCompressor(){
    compressor.setClosedLoopControl(false);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
