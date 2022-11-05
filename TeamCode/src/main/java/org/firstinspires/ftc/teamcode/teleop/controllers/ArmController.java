package org.firstinspires.ftc.teamcode.teleop.controllers;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmController {
    private final Servo arm;

    public ArmController(HardwareMap map) {
        this.arm = map.get(Servo.class, "arm");
    }
}
