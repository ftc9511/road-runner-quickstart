package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class LinearSlideController {
    private DcMotor motor;
    private final int EXTEND_TICKS = -2250;
    private final int RETRACT_TICKS = 5;

    public LinearSlideController(HardwareMap map) {
        this.motor = map.get(DcMotor.class, "linear_slide");
        this.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void extend() {
        this.motor.setTargetPosition(this.EXTEND_TICKS);
        this.motor.setPower(0.75);
    }
    public void retract() {
        this.motor.setTargetPosition(this.RETRACT_TICKS);
        this.motor.setPower(0.75);
    }

    public boolean isExtended() {
        return this.motor.getCurrentPosition() == this.EXTEND_TICKS;
    }

    public boolean isRetracted() {
        return this.motor.getCurrentPosition() == this.RETRACT_TICKS;
    }
}
