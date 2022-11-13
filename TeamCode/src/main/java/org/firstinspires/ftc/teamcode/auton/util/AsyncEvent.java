package org.firstinspires.ftc.teamcode.auton.util;

public abstract class AsyncEvent {
    public int time;
    public abstract boolean execute(double currTime);
}
