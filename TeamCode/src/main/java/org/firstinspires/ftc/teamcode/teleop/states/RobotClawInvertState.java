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
        // The claw moves fast enough to where it most likely won't get in the way
        // This is unsafe and creates a race condition but it's ok
        this.controller.claw.invert();
        return this.exit();
    }

    @Override
    public RobotState exit() throws NoNewStateException {
        throw new NoNewStateException(); // Go back to previous state
    }
}
