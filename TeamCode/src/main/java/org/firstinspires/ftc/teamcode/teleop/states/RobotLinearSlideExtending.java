package org.firstinspires.ftc.teamcode.teleop.states;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.NoNewStateException;
import org.firstinspires.ftc.teamcode.teleop.states.lib.RobotState;

public class RobotLinearSlideExtending extends RobotState {

    @Override
    public void enter(RobotController controller) {
        controller.slide.extend();
    }

    @Override
    public RobotState loop(RobotController controller) throws NoNewStateException {
        if (controller.slide.isExtended()) {
            // this.isDone = true;
        }
        return this;
    }

    @Override
    public RobotState exit(RobotController controller) throws NoNewStateException {
        throw new NoNewStateException();
    }
}
