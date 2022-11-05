package org.firstinspires.ftc.teamcode.teleop.states;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.NoNewStateException;
import org.firstinspires.ftc.teamcode.teleop.states.lib.RobotState;
import org.firstinspires.ftc.teamcode.teleop.controllers.ClawController.ClawState;

public class ClawReleaseState extends RobotState {

    @Override
    public void enter(RobotController controller) {
        controller.claw.expand();
    }

    @Override
    public RobotState loop() throws NoNewStateException {
        if (!(controller.claw.state == ClawState.OPEN)) {
            return this.exit();
        }
        return this;
    }

    @Override
    public RobotState exit() throws NoNewStateException {
        throw new NoNewStateException(); // Go back to previous state
    }
}
