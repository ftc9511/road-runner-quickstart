package org.firstinspires.ftc.teamcode.teleop.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.teleop.base.BaseRobot;
import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;

@TeleOp(name="[No-FSM] 9511 Movement TeleOP")
public class CompetitionTeleOP extends BaseRobot {
    private Gamepad gamepad;
    private RobotController controller;

    @Override
    public void init() {
        this.gamepad = gamepad1;
        this.controller = new RobotController(hardwareMap, telemetry, this.gamepad);
    }

    @Override
    public void loop() {
        // Calculate drivetrain values and apply them
        double x = -this.controller.gamepad.left_stick_y;
        double y = this.controller.gamepad.left_stick_x;
        double z = this.controller.gamepad.right_stick_x;

        this.controller.motors.mecanumDrive(y, x, z);

        // Extremity movements
        if (this.controller.gamepad.left_trigger > 0) {
            this.controller.claw.invert();
        }

        if (this.controller.gamepad.dpad_up) {
            // this.controller.slide.extend();
            this.controller.slide.manualControl(1);
        }
        if (this.controller.gamepad.dpad_down) {
            //this.controller.slide.retract();
            this.controller.slide.manualControl(-1);
        }
        if (!(this.controller.gamepad.dpad_down | this.controller.gamepad.dpad_up)) {
            this.controller.slide.manualControl(0);
        }

        if (this.controller.gamepad.a) {
            this.controller.arm.invert();
        }

    }
}
