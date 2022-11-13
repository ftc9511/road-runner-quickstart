package org.firstinspires.ftc.teamcode.auton.util.Events;


import org.firstinspires.ftc.teamcode.auton.util.AsyncEvent;

public class RunnableEvent extends AsyncEvent {
    protected Runnable action;

    public RunnableEvent(int time, Runnable action) {
        this.time = time;
        this.action = action;
    }

    public boolean execute(double currTime) {
        action.run();
        return true;
    }
}
