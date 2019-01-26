/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 * Add your docs here.
 */
public class Gyro extends Subsystem {
	private static Gyro m_singleton;
	private ADXRS450_Gyro m_gyro;

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	private Gyro() {
		m_gyro = new ADXRS450_Gyro( RobotMap.spiGyroPort );
	}

	double getAngle() {
		return m_gyro.getAngle();
	}

	public static Gyro getInstance() {
		if (m_singleton == null) {
			m_singleton = new Gyro();
		}
		return m_singleton;
	}
}
