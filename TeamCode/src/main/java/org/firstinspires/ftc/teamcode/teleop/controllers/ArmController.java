package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotConstants;

public class ArmController {
    private final Servo arm;

    public enum ArmState {
        RAISED,
        LOWERED
    }

    public ArmState state;

    public ArmController(HardwareMap map) {
        this.arm = map.get(Servo.class, "arm");
        this.state = ArmState.LOWERED;
        this.lower();
    }

    public void lower() {
        this.arm.setPosition(RobotConstants.ARM_LOWERED);
        this.state = ArmState.LOWERED;
    }

    public void raise() {
        this.arm.setPosition(RobotConstants.ARM_RAISED);
        this.state = ArmState.RAISED;
    }

}
