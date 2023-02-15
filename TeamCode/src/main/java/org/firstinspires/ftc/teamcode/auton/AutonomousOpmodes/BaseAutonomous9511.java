package org.firstinspires.ftc.teamcode.auton.AutonomousOpmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.RobotConstants;
import org.firstinspires.ftc.teamcode.auton.Vision.AprilTagDetectionPipeline;
import org.firstinspires.ftc.teamcode.auton.drive.SampleMecanumDrive;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseAutonomous9511 extends LinearOpMode {

    protected SampleMecanumDrive drive;
    protected ElapsedTime runtime = new ElapsedTime();

    OpenCvCamera camera;
    AprilTagDetectionPipeline aprilTagDetectionPipeline;
    static final double FEET_PER_METER = 3.28084;
    double fx = 578.272;
    double fy = 578.272;
    double cx = 402.145;
    double cy = 221.506;
    double tagsize = 0.166;
    int LEFT = 1;
    int MIDDLE = 2;
    int RIGHT = 3;
    AprilTagDetection tagOfInterest = null;
    int PARKINGTARGET = 1;

    protected DcMotorEx lift;
    protected Servo shoulder;
    protected Servo leftGrabber;
    protected Servo rightGrabber;

    protected DcMotorEx leftFront;
    protected DcMotorEx leftRear;
    protected DcMotorEx rightFront;
    protected DcMotorEx rightRear;

    protected double LEFT_OPEN = RobotConstants.CLAW_LEFT_OPEN;
    protected double LEFT_CLOSED = RobotConstants.CLAW_LEFT_CLOSED;
    protected double RIGHT_OPEN = RobotConstants.CLAW_RIGHT_OPEN;
    protected double RIGHT_CLOSED = RobotConstants.CLAW_RIGHT_CLOSED;
    protected int ZERO_POSITION;
    public RobotController controller;

    protected void initRobot(){
        initState("Starting");

        initState("Drivetrain");
//        drive = new SampleMecanumDrive(hardwareMap);
        leftFront = hardwareMap.get(DcMotorEx.class, "fl");
        leftRear = hardwareMap.get(DcMotorEx.class, "bl");
        rightRear = hardwareMap.get(DcMotorEx.class, "br");
        rightFront = hardwareMap.get(DcMotorEx.class, "fr");

        initState("Servos");
        this.controller = new RobotController(hardwareMap, telemetry);
        initState("Motors");
        grabbingPosition();

        initState("Vision");
        initVision();

        initState("Done");
    }

    protected void initState(String step) {
        telemetry.addData("Initializing", step);
        telemetry.update();
    }

    protected void initVision(){
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        aprilTagDetectionPipeline = new AprilTagDetectionPipeline(tagsize, fx, fy, cx, cy);

        camera.setPipeline(aprilTagDetectionPipeline);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                camera.startStreaming(800,448, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode)
            {

            }
        });

        telemetry.setMsTransmissionInterval(50);
    }

    protected void waitForStartVisionPipeline(){
        while (!isStarted() && !isStopRequested())
        {
            ArrayList<AprilTagDetection> currentDetections = aprilTagDetectionPipeline.getLatestDetections();

            if(currentDetections.size() != 0)
            {
                boolean tagFound = false;

                for(AprilTagDetection tag : currentDetections)
                {
                    if(tag.id == LEFT || tag.id == MIDDLE || tag.id == RIGHT)
                    {
                        tagOfInterest = tag;
                        tagFound = true;
                        break;
                    }
                }

                if(tagFound)
                {
                    telemetry.addLine("Tag of interest is in sight!\n\nLocation data:");
                    tagToTelemetry(tagOfInterest);
                }
                else
                {
                    telemetry.addLine("Don't see tag of interest :(");

                    if(tagOfInterest == null)
                    {
                        telemetry.addLine("(The tag has never been seen)");
                    }
                    else
                    {
                        telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                        tagToTelemetry(tagOfInterest);
                    }
                }

            }
            else
            {
                telemetry.addLine("Don't see tag of interest :(");

                if(tagOfInterest == null)
                {
                    telemetry.addLine("(The tag has never been seen)");
                }
                else
                {
                    telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                    tagToTelemetry(tagOfInterest);
                }

            }

            telemetry.update();
            sleep(20);
        }
    }

    protected void telemetryVision(){
        if(tagOfInterest != null)
        {
            telemetry.addLine("Tag snapshot:\n");
            tagToTelemetry(tagOfInterest);
            telemetry.update();
        }
        else
        {
            telemetry.addLine("No tag snapshot available, it was never sighted during the init loop :(");
            telemetry.update();
        }
    }

    void tagToTelemetry(AprilTagDetection detection)
    {
        telemetry.addLine(String.format("\nDetected tag ID=%d", detection.id));
        telemetry.addLine(String.format("Translation X: %.2f feet", detection.pose.x*FEET_PER_METER));
        telemetry.addLine(String.format("Translation Y: %.2f feet", detection.pose.y*FEET_PER_METER));
        telemetry.addLine(String.format("Translation Z: %.2f feet", detection.pose.z*FEET_PER_METER));
        telemetry.addLine(String.format("Rotation Yaw: %.2f degrees", Math.toDegrees(detection.pose.yaw)));
        telemetry.addLine(String.format("Rotation Pitch: %.2f degrees", Math.toDegrees(detection.pose.pitch)));
        telemetry.addLine(String.format("Rotation Roll: %.2f degrees", Math.toDegrees(detection.pose.roll)));
    }

    protected void resetPose(SampleMecanumDrive drive){
        drive.setPoseEstimate(new Pose2d(0, 0, 0));
    }

    protected void resetPose(double x, double y) {
        resetPose(x, y, 0);
    }

    protected void resetPose(double x, double y, double heading) {
        drive.setPoseEstimate(new Pose2d(x, y, Math.toRadians(heading)));
    }

    protected void waitForStop() {
        while (opModeIsActive()) {
            idle();
        }
        stop();
    }

    protected void waitForTime(double milliseconds) {
        while (opModeIsActive() && runtime.milliseconds() < milliseconds) {
            idle();
        }
    }

    protected void detectSleeve(){
        if(tagOfInterest.id == LEFT || tagOfInterest == null){
            PARKINGTARGET = 1;
        } else if (tagOfInterest.id == MIDDLE){
            PARKINGTARGET = 2;
        } else{
            PARKINGTARGET = 3;
        }
    }

    protected void grabbingPosition(){
        this.controller.slide.fullRetract();
        this.controller.claw.invert();
    }

    protected void scoringPosition(){
        this.controller.slide.fullExtend();
        this.controller.claw.invert();
    }

    protected void forward (double power, long time){
        leftFront.setPower(power);
        leftRear.setPower(power);
        rightFront.setPower(power);
        rightRear.setPower(power);
        sleep(time*1000);
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }

    protected void back (double power, long time){
        leftFront.setPower(-power);
        leftRear.setPower(-power);
        rightFront.setPower(-power);
        rightRear.setPower(-power);
        sleep(time*1000);
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }

    protected void left (double power, long time){
        leftFront.setPower(-power);
        leftRear.setPower(power);
        rightFront.setPower(power);
        rightRear.setPower(-power);
        sleep(time*1000);
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }

    protected void right (double power, long time){
        leftFront.setPower(power);
        leftRear.setPower(-power);
        rightFront.setPower(-power);
        rightRear.setPower(power);
        sleep(time*1000);
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }
}