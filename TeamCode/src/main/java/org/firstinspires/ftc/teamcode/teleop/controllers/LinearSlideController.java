package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.RobotConstants;


public class LinearSlideController {

    private DcMotor motor;
    public int RETRACT_TICKS;

    public LinearSlideController(HardwareMap map) {
        this.motor = map.get(DcMotor.class, "lift");
        this.motor.setDirection(DcMotorSimple.Direction.REVERSE);
        this.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.RETRACT_TICKS = this.motor.getCurrentPosition();
        this.motor.setTargetPosition(this.RETRACT_TICKS);
        this.motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.motor.setPower(0.75);
    }
    public void fullExtend() {
        this.motor.setTargetPosition(RobotConstants.LINEAR_SLIDE_EXTEND_TICKS);
    }
    public void fullRetract() {
        this.motor.setTargetPosition(this.RETRACT_TICKS);
    }


    public void toRelativePosition(int pos) {
        this.motor.setTargetPosition(motor.getTargetPosition()+pos);
    }

}
