package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.RobotConstants;


public class LinearSlideController {
    private DcMotor motor;
    private int RETRACT_TICKS;

    public LinearSlideController(HardwareMap map) {
        this.motor = map.get(DcMotor.class, "lift");
        this.RETRACT_TICKS = this.motor.getCurrentPosition();
        this.motor.setDirection(DcMotorSimple.Direction.REVERSE);
        this.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void extend() {
        this.motor.setTargetPosition(RobotConstants.LINEAR_SLIDE_EXTEND_TICKS);
        this.motor.setPower(0.8);
    }
    public void retract() {
        this.motor.setTargetPosition(this.RETRACT_TICKS);
        this.motor.setPower(0.8);
    }

    public void manualControl(double direction) {
        this.motor.setPower(direction * 0.8);
    }

    public boolean isExtended() {
        return RobotConstants.LINEAR_SLIDE_EXTEND_TICKS < this.motor.getCurrentPosition() && this.motor.getCurrentPosition() < RobotConstants.LINEAR_SLIDE_EXTEND_TICKS+200;
    }

    public boolean isRetracted() {
        return this.RETRACT_TICKS < this.motor.getCurrentPosition() && this.motor.getCurrentPosition() < this.RETRACT_TICKS+30;
    }

    public void invert() {
        if (this.isExtended()) {
            this.retract();
        } else if (this.isRetracted()) {
            this.extend();
        } // Otherwise, we are currently moving and thus should not change state
    }
}
