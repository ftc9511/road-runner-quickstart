package org.firstinspires.ftc.teamcode.teleop.states.lib;


import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;

public abstract class RobotState {
    StateMachine machine;
    public abstract void enter(RobotController controller);
    public abstract RobotState loop(RobotController controller) throws NoNewStateException;
    public abstract RobotState exit(RobotController controller) throws NoNewStateException;
}
