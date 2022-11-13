package org.firstinspires.ftc.teamcode.auton.util.Events;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.auton.util.AsyncEvent;


public class PowerEvent extends AsyncEvent {
    protected DcMotor motor;
    protected double power;

    public PowerEvent(int time, DcMotor motor, double power) {
        this.time = time;
        this.motor = motor;
        this.power = power;
    }

    public boolean execute(double currTime) {
        motor.setPower(power);
        return true;
    }
}
