package org.firstinspires.ftc.teamcode.teleop.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotConstants;

@TeleOp(name="Claw Test OpMode")
public class ClawTestOpMode extends OpMode {
    private Servo left;
    private Servo right;

    @Override
    public void init() {
        this.left = hardwareMap.get(Servo.class, "left");
        this.right = hardwareMap.get(Servo.class, "right");
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_up) {
            this.left.setPosition(RobotConstants.CLAW_LEFT_OPEN);
            this.right.setPosition(RobotConstants.CLAW_RIGHT_OPEN);
        } else if (gamepad1.dpad_down) {
            this.left.setPosition(RobotConstants.CLAW_LEFT_OPEN);
            this.right.setPosition(RobotConstants.CLAW_RIGHT_OPEN);
        }
        telemetry.addData("left servo position: ", this.left.getPosition());
        telemetry.addData("right servo position: ", this.right.getPosition());

        telemetry.update();
    }
}
