package org.firstinspires.ftc.teamcode.teleop.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@Disabled
@TeleOp(name="Test TeleOP.")
public class TestTeleOP extends OpMode {
    private DcMotor front_right;
    private DcMotor front_left;
    private DcMotor back_right;
    private DcMotor back_left;
    private DcMotor[] motors;

    @Override
    public void init() {
        this.front_right = hardwareMap.get(DcMotor.class, "front_left");
        this.front_left = hardwareMap.get(DcMotor.class, "front_right");
        this.back_left = hardwareMap.get(DcMotor.class, "back_left");
        this.back_right = hardwareMap.get(DcMotor.class, "back_right");
        this.motors = new DcMotor[] {this.front_left, this.back_left, this.front_right, this.back_right};
    }

    @Override
    public void loop() {
        if (this.gamepad1.a) {
            for (DcMotor motor: this.motors) {
                motor.setPower(0.5);
            }
        } else {
            for (DcMotor motor: this.motors) {
                motor.setPower(0.0);
            }
        }
    }
}
