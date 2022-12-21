// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxAlternateEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  CANSparkMax m_left= new CANSparkMax(0,MotorType.kBrushless);
  CANSparkMax m_right= new CANSparkMax(1,MotorType.kBrushless);
  DifferentialDrive m_mine= new DifferentialDrive (m_left,m_right);
  SparkMaxAlternateEncoder leftEncoder = m_left.getAlterateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature,20);
  SparkMaxAlternateEncoder rightEncoder = m_right.getAlterateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature,20);
  private int diameter=100;
  public DriveBase() {}
  public void arcadeDrive(double x, double z){
    m_mine.arcadeDrive(x,z);
  }
  public void resetEncoder(){
    m_leftEncoder.setPosition(0);
    m_rightEncoder.setPosition(0);
  }

  public double getLeftdist(){
    return m_leftEncoder.getPosition()*diameter*Math.PI;
  }
   public double getRighttdist(){
    return m_rightEncoder.getPosition()*diameter*Math.PI;
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
