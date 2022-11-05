package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawController {
    private final Servo left;
    private final Servo right;

    private final double LEFT_OPEN = 0;
    private final double LEFT_CLOSED = 0.4;
    private final double RIGHT_OPEN = 1;
    private final double RIGHT_CLOSED = 0.6;
    public ClawState state;

    public enum ClawState {
        GRAB,
        OPEN
    }


    public ClawController(HardwareMap map) {
        this.left = map.get(Servo.class, "left_claw");
        this.right = map.get(Servo.class, "right_claw");
        this.expand();
    }

    public void expand() {
        this.left.setPosition(LEFT_OPEN);
        this.right.setPosition(RIGHT_OPEN);
        this.state = ClawState.OPEN;
    }

    public void grab() {
        this.left.setPosition(LEFT_CLOSED);
        this.right.setPosition(RIGHT_CLOSED);
        this.state = ClawState.GRAB;
    }
}
