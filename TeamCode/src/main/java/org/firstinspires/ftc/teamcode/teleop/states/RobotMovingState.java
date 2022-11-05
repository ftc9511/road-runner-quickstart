package org.firstinspires.ftc.teamcode.teleop.states;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.lib.NoNewStateException;
import org.firstinspires.ftc.teamcode.teleop.states.lib.RobotState;

public class RobotMovingState extends RobotState {
    public void enter(RobotController controller) {}
    public RobotState loop() throws NoNewStateException {
        // left goes up down left right
        // right rotates

        double x = -controller.gamepad.left_stick_y;
        double y = controller.gamepad.left_stick_x;
        double z = controller.gamepad.right_stick_x;

        controller.motors.mecanumDrive(y, x, z);

        if (controller.gamepad.left_trigger > 0) {
            return new ClawGrabState();
        }
        if (controller.gamepad.dpad_up) {
            return new RobotLinearSlideExtend();
        }
        if (controller.gamepad.dpad_down) {
            return new RobotLinearSlideRetract();
        }
        return this;
    }
    public RobotState exit() throws NoNewStateException {
        throw new NoNewStateException();
    }
}
