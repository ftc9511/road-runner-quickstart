package org.firstinspires.ftc.teamcode.teleop.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RobotConstants;
import org.firstinspires.ftc.teamcode.teleop.base.BaseRobot;
import org.firstinspires.ftc.teamcode.teleop.controllers.ClawController;
import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;

@TeleOp(name="[No-FSM] 9511 Movement TeleOP")
public class CompetitionTeleOP extends BaseRobot {
    private Gamepad gamepad;
    private RobotController controller;

    @Override
    public void init() {
        this.gamepad = gamepad1;
        this.controller = new RobotController(hardwareMap, telemetry, this.gamepad);
        this.controller.claw.state = ClawController.ClawState.GRAB;
        this.controller.claw.invert();
    }

    @Override
    public void loop() {
        // Calculate drivetrain values and apply them
        double x = gamepad1.left_stick_x;
        double y = -gamepad1.left_stick_y;
        double z = gamepad1.right_stick_x;
        double slow = 1;
        if(this.controller.gamepad.b) {
            slow = 0.5;
        }
        this.controller.motors.mecanumDrive(y, x, z, slow);
        // Extremity movements
        if (this.controller.gamepad.right_bumper) {
            this.controller.claw.expand();
        } else if (this.controller.gamepad.left_bumper) {
            this.controller.claw.grab();
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

        this.telemetry.update();
    }
}
