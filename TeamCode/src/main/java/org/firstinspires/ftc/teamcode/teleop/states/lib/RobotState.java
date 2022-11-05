package org.firstinspires.ftc.teamcode.teleop.states.lib;


import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;

public abstract class RobotState {
    public RobotController controller;
    public abstract void enter(RobotController controller);
    public abstract RobotState loop() throws NoNewStateException;
    public abstract RobotState exit() throws NoNewStateException;
}
