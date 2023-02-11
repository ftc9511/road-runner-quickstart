package org.firstinspires.ftc.teamcode.auton.AutonomousOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class ConeAuton extends BaseAutonomous9511 {
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        waitForStartVisionPipeline();
        telemetryVision();
        detectSleeve();
        scoringPosition();
        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                .strafeRight(12)
                .build());
        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                .forward(5)
                .build());

        scoringPosition();

        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                .back(5)
                .build());
        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                .strafeLeft(12)
                .build());

        this.controller.claw.invert();
        this.controller.slide.fullRetract();
        

        if (PARKINGTARGET == 1) {
            drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                    .strafeLeft(24).build());
        } else if (PARKINGTARGET == 3) {
            drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                    .strafeRight(24)
                    .build());
        }
        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                .forward(21)
                .build());
    }
}