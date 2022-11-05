package org.firstinspires.ftc.teamcode.teleop.states;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.NoNewStateException;
import org.firstinspires.ftc.teamcode.teleop.states.lib.RobotState;

public class RobotIdleState extends RobotState {

    @Override
    public void enter(RobotController controller) {}
    @Override
    public RobotState loop() throws NoNewStateException {
        return this;
    }
    @Override
    public RobotState exit() throws NoNewStateException {
        throw new NoNewStateException();
    };
}