package org.firstinspires.ftc.teamcode.auton.AutonomousOpmodes.Test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.auton.AutonomousOpmodes.BaseAutonomous9511;

@Autonomous
public class TestAuto extends BaseAutonomous9511{
    protected DcMotorEx leftFront;
    protected DcMotorEx leftRear;
    protected DcMotorEx rightFront;
    protected DcMotorEx rightRear;
    @Override
    public void runOpMode() throws InterruptedException {
//        initRobot();

        leftFront = hardwareMap.get(DcMotorEx.class, "fl");
        leftRear = hardwareMap.get(DcMotorEx.class, "bl");
        rightRear = hardwareMap.get(DcMotorEx.class, "br");
        rightFront = hardwareMap.get(DcMotorEx.class, "fr");

        waitForStart();

//        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
//                .forward(60)
//                .build());
//        sleep(2000);
//        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
//                .strafeLeft(60)
//                .build());
//        sleep(2000);
//        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
//                .strafeRight(60)
//                .build());
//        sleep(2000);
//        drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate())
//                .back(60)
//                .build());
        leftRear.setPower(1);
//        sleep(3000);
        leftRear.setPower(0);
        rightRear.setPower(1);
//        sleep(3000);
        rightRear.setPower(0);
        leftFront.setPower(1);
//        sleep(3000);
        leftFront.setPower(0);
        rightFront.setPower(1);
//        sleep(3000);
        rightFront.setPower(0);

    }
}
