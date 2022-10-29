package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawController {
    private Servo left;
    private Servo right;

    private int LEFT_OPEN = 0;
    private double LEFT_CLOSED = 0.4;
    private int RIGHT_OPEN = 1;
    private double RIGHT_CLOSED = 0.6;


    public ClawController(HardwareMap map) {
        this.left = map.get(Servo.class, "left_claw");
        this.right = map.get(Servo.class, "right_claw");
    }

    public void expand() {
        this.left.setPosition(LEFT_OPEN);
        this.right.setPosition(RIGHT_OPEN);
    }

    public void grab() {
        this.left.setPosition(LEFT_OPEN);
        this.right.setPosition(RIGHT_OPEN);
    }

    public boolean isExtended() {
        return this.left.getPosition() == this.LEFT_OPEN && this.right.getPosition() == this.RIGHT_OPEN;
    }

    public boolean isRetracted() {
        return this.left.getPosition() == this.LEFT_CLOSED && this.right.getPosition() == this.LEFT_CLOSED;
    }
}
