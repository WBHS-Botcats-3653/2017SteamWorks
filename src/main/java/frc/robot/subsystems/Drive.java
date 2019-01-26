/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.subsystems.Gyro;
import frc.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Drive extends Subsystem {

	private static Drive m_singleton;
	private VictorSP m_frontLeft, m_frontRight, m_backLeft, m_backRight;
	private MecanumDrive m_drive;
	private Gyro m_gyro;

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand( new DriveCommand() );
	}

	private Drive() {
		m_backLeft = new VictorSP( RobotMap.pwmLeftBack );
		m_frontLeft = new VictorSP( RobotMap.pwmLeftFront );
		m_backRight = new VictorSP( RobotMap.pwmRightBack );
		m_frontRight = new VictorSP( RobotMap.pwmRightFront );

		m_drive = new MecanumDrive( m_frontLeft, m_backLeft, m_frontRight, m_backRight );

		m_gyro = Gyro.getInstance();
	}

	public void driveCartesian( double xSpeed, double ySpeed, double zRotation ) {
		m_drive.driveCartesian( xSpeed, ySpeed, zRotation );
	}

	public void driveField( double ySpeed, double xSpeed, double zRotation, double gyro ) {
		m_drive.driveCartesian( ySpeed, xSpeed, zRotation, m_gyro.getAngle() );
	}

	public static Drive getInstance() {
		if (m_singleton == null) {
			m_singleton = new Drive();
		}
		return m_singleton;
	}
}
