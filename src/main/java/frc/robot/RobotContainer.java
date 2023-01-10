// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.team5431.titan.core.joysticks.CommandXboxController;
import frc.team5431.titan.core.solenoid.DoubleSolenoid;

import static edu.wpi.first.wpilibj2.command.Commands.*;

public class RobotContainer {
  public final Compressor compressor;
  public final DoubleSolenoid dblSol1;
  public final DoubleSolenoid dblSol2;
  public final DoubleSolenoid dblSol3;
  public final CommandXboxController xbox = new CommandXboxController(0);

  public RobotContainer() {
    compressor = new Compressor(31, PneumaticsModuleType.CTREPCM);
    compressor.enableDigital();
    dblSol1 = new DoubleSolenoid(31, PneumaticsModuleType.CTREPCM, 0, 1);
    dblSol2 = new DoubleSolenoid(31, PneumaticsModuleType.CTREPCM, 2, 3);
    dblSol3 = new DoubleSolenoid(31, PneumaticsModuleType.CTREPCM, 6, 7);
    dblSol1.set(Value.kForward);
    dblSol2.set(Value.kForward);
    dblSol3.set(Value.kForward);

    configureBindings();
  }

  private void configureBindings() {
    xbox.a().onTrue(runOnce(() -> dblSol1.set(Value.kForward)));
    xbox.b().onTrue(runOnce(() -> dblSol1.set(Value.kReverse)));
    xbox.x().onTrue(runOnce(() -> dblSol2.set(Value.kForward)));
    xbox.y().onTrue(runOnce(() -> dblSol2.set(Value.kReverse)));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
