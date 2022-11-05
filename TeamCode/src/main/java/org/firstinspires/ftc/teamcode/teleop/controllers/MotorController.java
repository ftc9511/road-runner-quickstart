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
    }

    public void mecanumDrive(double y, double x, double z) {
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