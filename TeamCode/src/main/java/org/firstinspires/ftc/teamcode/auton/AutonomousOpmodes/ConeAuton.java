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

        right(0.25, 1);
        forward(0.2,1);

        scoringPosition(true);

        back(0.2,1);
        left(0.25, 1);

        grabbingPosition();

        if (PARKINGTARGET == 1){
            left(0.5,1);
        } else if (PARKINGTARGET == 3){
            right(0.5,1);
        }
        forward(0.4,1);
    }
}