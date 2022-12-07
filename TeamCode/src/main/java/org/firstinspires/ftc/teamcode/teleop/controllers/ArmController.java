package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotConstants;

public class ArmController {
    private final Servo arm;
    public ArmState state;

    public enum ArmState {
        RAISED,
        LOWERED
    }


    public ArmController(HardwareMap map) {
        this.arm = map.get(Servo.class, "shoulder");
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

    public void invert() {
        if (this.state == ArmState.RAISED) {
            this.lower();
        } else if (this.state == ArmState.LOWERED) {
            this.raise();
        }
    }

}
