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
            left(0.5,1);
        } else if (PARKINGTARGET == 3){
            right(0.5,1);
        }
        forward(0.4,1);

    }
}
