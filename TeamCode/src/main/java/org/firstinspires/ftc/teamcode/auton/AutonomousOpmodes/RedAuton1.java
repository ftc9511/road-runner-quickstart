package org.firstinspires.ftc.teamcode.auton.AutonomousOpmodes;

public class RedAuton1 extends BaseAutonomous9511{
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStartVisionPipeline();

        telemetryVision();

        if(tagOfInterest.id == LEFT || tagOfInterest == null){
            //LEFT case autonomous
        } else if (tagOfInterest.id == MIDDLE){
            //MIDDLE case autonomous
        } else{
            //RIGHT case autonomous
        }
    }
}
