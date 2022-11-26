package org.firstinspires.ftc.teamcode.teleop.states;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.NoNewStateException;
import org.firstinspires.ftc.teamcode.teleop.states.lib.RobotState;

public class RobotClawInvertState extends RobotState {
    @Override
    public void enter(RobotController controller) {
        this.controller = controller;
        this.controller.claw.expand();
    }

    @Override
    public RobotState loop() throws NoNewStateException {
        switch (this.controller.claw.state) {
            case GRAB:
                this.controller.claw.expand();
                break;
            case OPEN:
                this.controller.claw.grab();
                break;
        }
        return this.exit();
    }

    @Override
    public RobotState exit() throws NoNewStateException {
        throw new NoNewStateException(); // Go back to previous state
    }
}
