package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class MotorController {
    public DcMotor front_right;
    public DcMotor front_left;
    public DcMotor back_left;
    public DcMotor back_right;
    public DcMotor[] motors;

    public MotorController(HardwareMap map) {
        this.front_right = map.get(DcMotor.class, "front_left");
        this.front_left = map.get(DcMotor.class, "front_right");
        this.back_left = map.get(DcMotor.class, "back_left");
        this.back_right = map.get(DcMotor.class, "back_right");
        this.motors = new DcMotor[] {front_right, front_left, back_left, back_right};
        // this.front_left.setDirection(DcMotor.Direction.FORWARD);
        // this.back_left.setDirection(DcMotor.Direction.FORWARD);
        // this.front_right.setDirection(DcMotor.Direction.REVERSE);
        // this.back_right.setDirection(DcMotor.Direction.REVERSE);
    }

    public void mecanumDrive(double y, double x, double z) {
        /*
                rx *= 0.1;
                double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

                this.front_left.setPower((y + x + rx) / denominator);
                this.back_left.setPower((y - x + rx) / denominator);
                this.front_right.setPower(-((y - x - rx) / denominator));
                this.back_right.setPower(-((y + x - rx) / denominator));
        */

        double v1 = Range.clip(y - x + z, -1, 1);
        double v2 = Range.clip(y + x - z, -1, 1);
        double v3 = Range.clip(y + x + z, -1, 1);
        double v4 = Range.clip(y - x - z, -1, 1);

        this.front_left.setPower(v1);
        this.front_right.setPower(v2);
        this.back_left.setPower(v3);
        this.back_right.setPower(v4);
    }
}