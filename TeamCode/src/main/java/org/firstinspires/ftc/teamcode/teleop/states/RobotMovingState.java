package org.firstinspires.ftc.teamcode.teleop.states;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.NoNewStateException;
import org.firstinspires.ftc.teamcode.teleop.states.lib.RobotState;

public class RobotMovingState extends RobotState {
    public void enter(RobotController controller) {
        this.controller = controller;
    }
    public RobotState loop() throws NoNewStateException {

        double x = -this.controller.gamepad.left_stick_y;
        double y = this.controller.gamepad.left_stick_x;
        double z = this.controller.gamepad.right_stick_x;

        // this.controller.motors.mecanumDrive(y, x, z, );

        if (this.controller.gamepad.left_trigger > 0) {
            return new RobotClawInvertState();
        }

        if (this.controller.gamepad.dpad_up) {
            return new RobotLinearSlideInvertState();
        }

        if (this.controller.gamepad.a) {
            return new RobotArmInvertState();
        }

        return this;
    }
    public RobotState exit() throws NoNewStateException {
        throw new NoNewStateException();
    }
}
