package org.firstinspires.ftc.teamcode.teleop.states;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.NoNewStateException;
import org.firstinspires.ftc.teamcode.teleop.states.lib.RobotState;

public class RobotLinearSlideInvertState extends RobotState {
    public void enter(RobotController controller) {
        if (controller.slide.isRetracted()) {
            controller.slide.extend();
        } else {
            controller.slide.retract();
        }
    }

    @Override
    public RobotState loop() throws NoNewStateException {
        return this.exit();
    }

    @Override
    public RobotState exit() throws NoNewStateException {
        throw new NoNewStateException();
    }


}
