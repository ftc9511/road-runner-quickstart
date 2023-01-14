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
        this.front_right = map.get(DcMotor.class, "fl");
        this.front_left = map.get(DcMotor.class, "fr");
        this.back_left = map.get(DcMotor.class, "bl");
        this.back_right = map.get(DcMotor.class, "br");
        this.motors = new DcMotor[] {front_right, front_left, back_left, back_right};
    }

    public void mecanumDrive(double y, double x, double z, boolean slow) {
        double v1 = Range.clip(y - x + z, -1, 1);
        double v2 = Range.clip(y + x - z, -1, 1);
        double v3 = Range.clip(y + x + z, -1, 1);
        double v4 = Range.clip(y - x - z, -1, 1);
        if (slow) {
            this.front_left.setPower(v1 * 0.5);
            this.front_right.setPower(v2 * 0.5);
            this.back_left.setPower(v3 * 0.5);
            this.back_right.setPower(v4 * 0.5);
        } else {
            this.front_left.setPower(v1);
            this.front_right.setPower(v2);
            this.back_left.setPower(v3);
            this.back_right.setPower(v4);
        }
    }
}