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

        if(tagOfInterest.id == LEFT || tagOfInterest == null){
            drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                    .strafeLeft(24)
                    .forward(30)
                    .build());
        } else if (tagOfInterest.id == MIDDLE){
            drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                    .forward(30)
                    .build());
        } else{
            drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
                    .strafeRight(24)
                    .forward(30)
                    .build());
        }
    }
}
