package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class LinearSlideController {
    private DcMotor motor;
    private final int EXTEND_TICKS = -2250;
    private int RETRACT_TICKS;

    public LinearSlideController(HardwareMap map) {
        this.motor = map.get(DcMotor.class, "linear_slide");
        this.RETRACT_TICKS = this.motor.getCurrentPosition();
        this.motor.setDirection(DcMotorSimple.Direction.REVERSE);
        this.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void extend() {
        this.motor.setTargetPosition(this.EXTEND_TICKS);
        this.motor.setPower(0.8);
    }
    public void retract() {
        this.motor.setTargetPosition(this.RETRACT_TICKS);
        this.motor.setPower(0.8);
    }

    public boolean isExtended() {
        return this.EXTEND_TICKS < this.motor.getCurrentPosition() && this.motor.getCurrentPosition() < this.EXTEND_TICKS+200;
    }

    public boolean isRetracted() {
        return this.RETRACT_TICKS < this.motor.getCurrentPosition() && this.motor.getCurrentPosition() < this.RETRACT_TICKS+30;
    }
}
