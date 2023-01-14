package org.firstinspires.ftc.teamcode.teleop.controllers;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.util.concurrent.locks.Lock;


public class TimedLock {
    private Lock lock;
    private int delay;

    public TimedLock(int delay) {
        this.delay = delay;
    }

    public void invert() {

    }
}
