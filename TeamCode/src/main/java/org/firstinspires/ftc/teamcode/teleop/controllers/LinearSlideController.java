package org.firstinspires.ftc.teamcode.teleop.controllers;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.RobotConstants;


public class LinearSlideController {

    private DcMotor motor;
    public int RETRACT_TICKS;
    public int targetTicks;

    public LinearSlideController(HardwareMap map) {
        this.motor = map.get(DcMotor.class, "lift");
        this.motor.setDirection(DcMotorSimple.Direction.REVERSE);
        this.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.RETRACT_TICKS = this.motor.getCurrentPosition();
        this.motor.setTargetPosition(this.RETRACT_TICKS);
        this.motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.targetTicks = this.RETRACT_TICKS;
    }
    public void fullExtend() {
        this.motor.setTargetPosition(RobotConstants.LINEAR_SLIDE_EXTEND_TICKS);
    }
    public void fullRetract() {
        this.motor.setTargetPosition(this.RETRACT_TICKS);
    }

    public void manualControl(double direction) {
        this.motor.setPower(direction * 0.8);
    }

    public void toPosition(int amount) {
        this.targetTicks += amount;
        int liftPosition = Range.clip(this.targetTicks, this.RETRACT_TICKS, this.RETRACT_TICKS + RobotConstants.LINEAR_SLIDE_EXTEND_TICKS);
        this.motor.setTargetPosition(liftPosition);
        this.motor.setPower(max(0.2, abs(liftPosition - this.motor.getCurrentPosition()) / 500.0));
    }
}
