package org.firstinspires.ftc.teamcode.teleop.base;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.StateMachine;


public abstract class BaseRobot extends OpMode {
    public StateMachine machine;
    public RobotController controller;

    public abstract void init();
    public abstract void loop();
}