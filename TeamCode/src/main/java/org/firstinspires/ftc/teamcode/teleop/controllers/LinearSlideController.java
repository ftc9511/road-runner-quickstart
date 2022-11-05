package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class LinearSlideController {
    private DcMotor motor;
    private final int EXTEND_TICKS = 0;
    private final int RETRACT_TICKS = 100;

    public LinearSlideController(HardwareMap map) {
        this.motor = map.get(DcMotor.class, "linear_slide");
        this.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void extend() {}
    public void retract() {}

    public boolean isExtended() {
        return this.motor.getCurrentPosition() == EXTEND_TICKS;
    }

    public boolean isExtending() {
        return this.motor.getCurrentPosition() == RETRACT_TICKS;
    }
}
