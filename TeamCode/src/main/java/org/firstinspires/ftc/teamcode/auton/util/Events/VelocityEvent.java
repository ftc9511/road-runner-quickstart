package org.firstinspires.ftc.teamcode.auton.util.Events;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.auton.util.AsyncEvent;

public class VelocityEvent extends AsyncEvent {
    protected DcMotorEx motorEx;
    protected int velocity;


    public VelocityEvent(int time, DcMotorEx motorEx, int velocity) {
        this.time = time;
        this.motorEx = motorEx;
        this.velocity = velocity;
    }


    public boolean execute(double currTime) {
        motorEx.setVelocity(velocity);
        return true;
    }
}
