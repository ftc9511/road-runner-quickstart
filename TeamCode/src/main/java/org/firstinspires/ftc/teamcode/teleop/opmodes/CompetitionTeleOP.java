package org.firstinspires.ftc.teamcode.teleop.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.teleop.base.BaseRobot;
import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;

@TeleOp(name="9511 Movement TeleOP")
public class CompetitionTeleOP extends BaseRobot {
    private RobotController controller;

    @Override
    public void init() {
        this.controller = new RobotController(hardwareMap, telemetry);
    }

    @Override
    public void loop() {
        // Calculate drivetrain values and apply them
        double x = -gamepad1.right_stick_x;
        double y = -gamepad1.left_stick_y;
        double z = -gamepad1.left_stick_x;
        double slow = 1;
        if (gamepad1.left_trigger > 0 || gamepad1.right_trigger > 0) {
            slow = 0.55;
        }
        if (gamepad1.right_trigger > 0 && gamepad1.left_trigger > 0) {
            slow = 0.30;
        }
        this.controller.motors.mecanumDrive(y, x, z, slow, telemetry);
        // Extremity movements
        if (gamepad1.right_bumper) {
            this.controller.claw.expand();
        }
        if (gamepad1.left_bumper) {
            this.controller.claw.grab();
        }
        if (gamepad1.dpad_up) {
            this.controller.slide.toRelativePosition(25);
        }
        if (gamepad1.dpad_down) {
            this.controller.slide.toRelativePosition(-25);
        }

        this.telemetry.update();
    }
}
