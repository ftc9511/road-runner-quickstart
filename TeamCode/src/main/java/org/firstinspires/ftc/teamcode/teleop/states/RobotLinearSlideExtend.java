package org.firstinspires.ftc.teamcode.teleop.states;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.NoNewStateException;
import org.firstinspires.ftc.teamcode.teleop.states.lib.RobotState;

public class RobotLinearSlideExtend extends RobotState {

    @Override
    public void enter(RobotController controller) {
        controller.slide.extend();
    }

    @Override
    public RobotState loop() throws NoNewStateException {
        if (this.controller.slide.isExtended()) {
            return this.exit();
        }
        return this;
    }

    @Override
    public RobotState exit() throws NoNewStateException {
        throw new NoNewStateException();
    }
}
