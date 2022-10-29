package org.firstinspires.ftc.teamcode.teleop.states;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.NoNewStateException;
import org.firstinspires.ftc.teamcode.teleop.states.lib.RobotState;

public class ClawGrabState extends RobotState {

    @Override
    public void enter(RobotController controller) {
        controller.claw.grab();
    }

    @Override
    public RobotState loop(RobotController controller) throws NoNewStateException {
        if (!controller.claw.isExtended()) {
            return this;
        }
        return this.exit(controller);
    }

    @Override
    public RobotState exit(RobotController controller) throws NoNewStateException {
        throw new NoNewStateException(); // Go back to previous state
    }
}
