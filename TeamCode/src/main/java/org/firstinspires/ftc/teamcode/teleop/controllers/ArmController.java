package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmController {
    private final Servo arm;

    public enum ArmState {
        RAISED,
        LOWERED
    }

    private double RAISED = 0.2688;
    private double LOWERED = 0.0988;
    public ArmState state;

    public ArmController(HardwareMap map) {
        this.arm = map.get(Servo.class, "arm");
        this.state = ArmState.LOWERED;
        this.lower();
    }

    public void lower() {
        this.arm.setPosition(this.LOWERED);
        this.state = ArmState.LOWERED;
    }

    public void raise() {
        this.arm.setPosition(this.RAISED);
        this.state = ArmState.RAISED;
    }

}
