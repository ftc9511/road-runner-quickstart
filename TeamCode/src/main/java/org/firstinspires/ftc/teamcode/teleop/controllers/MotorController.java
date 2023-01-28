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
        this.front_right.setDirection(DcMotor.Direction.REVERSE);
        this.back_right.setDirection(DcMotor.Direction.REVERSE);
        this.motors = new DcMotor[] {front_right, front_left, back_left, back_right};
    }

    public void mecanumDrive(double y, double x, double z, boolean slow) {
        double coefficient = 1;
        if (slow) {
            coefficient = 0.5;
        }
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(z), 1);
        double frontLeftPower = (y + x + z) / denominator;
        double backLeftPower = (y - x + z) / denominator;
        double frontRightPower = (y - x - z) / denominator;
        double backRightPower = (y + x - z) / denominator;

        front_left.setPower(frontLeftPower);
        back_left.setPower(backLeftPower);
        front_right.setPower(frontRightPower);
        back_right.setPower(backRightPower);
    }
}