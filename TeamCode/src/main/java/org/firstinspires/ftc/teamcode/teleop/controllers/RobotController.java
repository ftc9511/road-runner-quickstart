package org.firstinspires.ftc.teamcode.teleop.controllers;


import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotController {
    public MotorController motors;
    public LinearSlideController slide;
    public ClawController claw;
    public ArmController arm;
    public Gamepad gamepad;
    public Telemetry telemetry;

    public RobotController(HardwareMap map, Telemetry telemetry, Gamepad gamepad) {
        this.motors = new MotorController(map);
        this.slide = new LinearSlideController(map);
        this.gamepad = gamepad;
        this.telemetry = telemetry;
        this.claw = new ClawController(map);
        this.arm = new ArmController(map);
    }
}