package org.firstinspires.ftc.teamcode.teleop.states;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.NoNewStateException;
import org.firstinspires.ftc.teamcode.teleop.states.lib.RobotState;
import org.firstinspires.ftc.teamcode.teleop.controllers.ClawController.ClawState;

public class ClawGrabState extends RobotState {

    @Override
    public void enter(RobotController controller) {
        this.controller = controller;
        this.controller.claw.grab();
    }

    @Override
    public RobotState loop() throws NoNewStateException {
        if (!(this.controller.claw.state == ClawState.OPEN)) {
            return this;
        }
        return this.exit();
    }

    @Override
    public RobotState exit() throws NoNewStateException {
        throw new NoNewStateException(); // Go back to previous state
    }
}
