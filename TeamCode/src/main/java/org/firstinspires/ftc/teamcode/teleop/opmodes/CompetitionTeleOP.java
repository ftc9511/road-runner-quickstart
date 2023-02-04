package org.firstinspires.ftc.teamcode.teleop.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RobotConstants;
import org.firstinspires.ftc.teamcode.teleop.base.BaseRobot;
import org.firstinspires.ftc.teamcode.teleop.controllers.ClawController;
import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;

@TeleOp(name="[No-FSM] 9511 Movement TeleOP")
public class CompetitionTeleOP extends BaseRobot {
    private Gamepad gamepad;
    private RobotController controller;
    private Servo left;
    private Servo right;

    @Override
    public void init() {
        this.controller = new RobotController(hardwareMap, telemetry);
        this.controller.claw.state = ClawController.ClawState.GRAB;
        this.controller.claw.invert();
        this.left = hardwareMap.get(Servo.class, "left");
        this.right = hardwareMap.get(Servo.class, "right");
    }

    @Override
    public void loop() {
        // Calculate drivetrain values and apply them
        double x = gamepad1.left_stick_x;
        // TODO: check if negative sign fixes motor inversion
        double y = -gamepad1.left_stick_y;
        double z = gamepad1.right_stick_x;
        double slow = 1;
        if (gamepad1.left_trigger > 0) {
            slow = 0.5;
        }
        if (gamepad1.right_trigger > 0 && gamepad1.left_trigger > 0) {
            slow = 0.25;
        }
        this.controller.motors.mecanumDrive(y, x, z, slow);
        // Extremity movements
        if (gamepad1.right_bumper) {
            this.controller.claw.expand();
        }
        if (gamepad1.left_bumper) {
            this.controller.claw.grab();
        }
        if (gamepad1.dpad_up) {
            // this.controller.slide.extend();
            this.controller.slide.manualControl(1);
        }
        if (gamepad1.dpad_down) {
            //this.controller.slide.retract();
            this.controller.slide.manualControl(-1);
        }
        if (!(gamepad1.dpad_down | gamepad1.dpad_up)) {
            this.controller.slide.manualControl(0);
        }

        this.telemetry.update();
    }
}
