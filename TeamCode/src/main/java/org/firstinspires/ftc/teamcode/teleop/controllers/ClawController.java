package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.teamcode.RobotConstants;

public class ClawController {
    private final Servo left;
    private final Servo right;
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
        this.left.setPosition(RobotConstants.CLAW_LEFT_OPEN);
        this.right.setPosition(RobotConstants.CLAW_RIGHT_OPEN);
        this.state = ClawState.OPEN;
    }

    public void grab() {
        this.left.setPosition(RobotConstants.CLAW_LEFT_CLOSED);
        this.right.setPosition(RobotConstants.CLAW_RIGHT_CLOSED);
        this.state = ClawState.GRAB;
    }
}
