package org.firstinspires.ftc.teamcode.teleop.states;

import org.firstinspires.ftc.teamcode.teleop.controllers.ClawController;
import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.NoNewStateException;
import org.firstinspires.ftc.teamcode.teleop.states.lib.RobotState;

public class ClawInvertState extends RobotState {
    @Override
    public void enter(RobotController controller) {
        this.controller = controller;
        this.controller.claw.expand();
    }

    @Override
    public RobotState loop() throws NoNewStateException {
        if (this.controller.claw.state == ClawController.ClawState.OPEN) {
            this.controller.claw.grab();
        } else {
            this.controller.claw.expand();
        }
        return this.exit();
    }

    @Override
    public RobotState exit() throws NoNewStateException {
        throw new NoNewStateException(); // Go back to previous state
    }
}
