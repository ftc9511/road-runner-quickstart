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
        scoringPosition(false);
        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                .strafeRight(12)
                .build());
        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                .forward(6)
                .build());

        scoringPosition(true);

        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                .back(6)
                .build());
        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                .strafeLeft(12)
                .build());

        leftGrabber.setPosition(LEFT_CLOSED);
        rightGrabber.setPosition(RIGHT_CLOSED);
        lift.setTargetPosition(ZERO_POSITION);

        if (PARKINGTARGET == 1) {
            drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                    .strafeLeft(24).build());
        } else if (PARKINGTARGET == 3) {
            drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                    .strafeRight(24)
                    .build());
        }
        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                .forward(24)
                .forward(21)
                .build());
    }
}