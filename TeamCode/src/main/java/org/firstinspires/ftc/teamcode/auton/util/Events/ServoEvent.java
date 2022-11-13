package org.firstinspires.ftc.teamcode.auton.util.Events;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.auton.util.AsyncEvent;

public class ServoEvent extends AsyncEvent {
    protected boolean slow;
    protected Servo servo;
    protected double startPosition;
    protected double endPosition;
    protected int duration;


    public ServoEvent(int time, Servo servo, double position) {
        slow = false;
        this.time = time;
        this.servo = servo;
        this.endPosition = position;
    }

    public ServoEvent(int time, Servo servo, double startPosition, double endPosition, int duration) {
        slow = true;
        this.time = time;
        this.servo = servo;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.duration = duration;
    }


    public boolean execute(double currTime) {
        double delta = currTime - time;
        if (slow && delta < duration) {
            servo.setPosition(startPosition + (endPosition - startPosition) * (delta / duration));
            return false;
        } else {
            servo.setPosition(endPosition);
            return true;
        }
    }
}
