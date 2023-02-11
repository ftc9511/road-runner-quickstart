package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

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
        front_right.setDirection(DcMotorSimple.Direction.REVERSE);
        front_left.setDirection(DcMotorSimple.Direction.FORWARD);
        back_left.setDirection(DcMotorSimple.Direction.FORWARD);
        back_right.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void mecanumDrive(double y, double x, double z, double slow, Telemetry telemetry) {
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(z), 1);

        this.front_left.setPower(((y + x + z) / denominator) * slow);
        this.back_left.setPower(((y - x + z) / denominator) * slow);
        this.front_right.setPower(((y - x - z) / denominator) * slow);
        this.back_right.setPower(((y + x - z) / denominator) * slow);
    }
}