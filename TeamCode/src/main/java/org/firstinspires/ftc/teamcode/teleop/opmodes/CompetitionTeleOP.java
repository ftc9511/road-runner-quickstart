package org.firstinspires.ftc.teamcode.teleop.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.teleop.base.BaseRobot;
import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;

@TeleOp(name="9511 Movement TeleOP")
public class CompetitionTeleOP extends BaseRobot {
    private RobotController controller;
    private final ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);

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
        if (gamepad2.right_bumper) {
            this.controller.claw.expand();
        }
        if (gamepad2.left_bumper) {
            this.controller.claw.grab();
        }
        if (this.timer.milliseconds() > 500) {
            if (gamepad2.dpad_up) {
                this.controller.slide.toPosition(25);
            }
            if (gamepad2.dpad_down) {
                this.controller.slide.toPosition(-25);
            }

            this.timer.reset();
        }

        this.telemetry.update();
    }
}
