package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

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
        front_right.setDirection(DcMotorSimple.Direction.FORWARD);
        front_left.setDirection(DcMotorSimple.Direction.REVERSE);
        back_left.setDirection(DcMotorSimple.Direction.FORWARD);
        back_right.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void mecanumDrive(double y, double x, double z, double slow) {
        double r = Math.hypot(x, y);
        double angle = Math.atan2(y, x) - Math.PI / 4;
        double[] powers = {r * Math.cos(angle) + z, r * Math.sin(angle) - z, r * Math.sin(angle) + z, r * Math.cos(angle) - z};
        for (int i = 0; i < 4; i++) {
            powers[i] *= -1;
            this.motors[i].setPower(powers[i] * slow);
        }
    }
}