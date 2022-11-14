package org.firstinspires.ftc.teamcode.auton.AutonomousOpmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class ParkAuton extends BaseAutonomous9511{
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStartVisionPipeline();

        telemetryVision();

        detectSleeve();

        drive.followTrajectory(PARKINGTARGET == 1 ? parkLeft : PARKINGTARGET == 2 ? parkMiddle : parkRight);

    }
}
