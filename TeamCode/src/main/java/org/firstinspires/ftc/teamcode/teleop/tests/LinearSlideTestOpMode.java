package org.firstinspires.ftc.teamcode.teleop.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Linear Slide TeleOp Test")
public class LinearSlideTestOpMode extends OpMode {
    private DcMotor linear_slide;

    @Override
    public void init() {
        this.linear_slide = hardwareMap.get(DcMotor.class, "lift");
        this.linear_slide.setDirection(DcMotorSimple.Direction.REVERSE);
        this.linear_slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.linear_slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_up) {
            this.linear_slide.setPower(0.15);
        } else if (gamepad1.dpad_down) {
            this.linear_slide.setPower(-0.15);
        } else {
            this.linear_slide.setPower(0);
        }
        telemetry.addData("Linear slide position: ", this.linear_slide.getCurrentPosition());
        telemetry.update();
    }
}
