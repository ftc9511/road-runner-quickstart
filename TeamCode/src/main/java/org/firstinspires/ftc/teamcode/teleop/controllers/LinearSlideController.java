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
        this.motor.setTargetPosition(this.RETRACT_TICKS);
        this.motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void extend() {
        this.motor.setTargetPosition(RobotConstants.LINEAR_SLIDE_EXTEND_TICKS);
    }
    public void retract() {
        this.motor.setTargetPosition(this.RETRACT_TICKS);
    }
}
