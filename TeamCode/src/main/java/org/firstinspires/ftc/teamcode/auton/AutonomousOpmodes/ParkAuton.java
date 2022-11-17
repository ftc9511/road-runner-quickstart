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

        if (PARKINGTARGET == 1){
            drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                    .strafeLeft(24)
                    .build());
        } else if (PARKINGTARGET == 3){
            drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                    .strafeRight(24)
                    .build());
        }
        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                .forward(24)
                .build());

    }
}
