package org.firstinspires.ftc.teamcode.teleop.states;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.NoNewStateException;
import org.firstinspires.ftc.teamcode.teleop.states.lib.RobotState;

public class ClawReleaseState extends RobotState {

    @Override
    public void enter(RobotController controller) {
        controller.claw.expand();
    }

    @Override
    public RobotState loop(RobotController controller) throws NoNewStateException {
        if (!controller.claw.isRetracted()) {
            return this.exit(controller);
        }
        return this;
    }

    @Override
    public RobotState exit(RobotController controller) throws NoNewStateException {
        throw new NoNewStateException(); // Go back to previous state
    }
}
