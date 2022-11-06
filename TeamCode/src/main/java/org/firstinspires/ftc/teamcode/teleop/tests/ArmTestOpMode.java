package org.firstinspires.ftc.teamcode.teleop.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Arm TeleOp Test")
public class ArmTestOpMode extends OpMode {
    private Servo arm;

    @Override
    public void init() {
        this.arm = hardwareMap.get(Servo.class, "arm");
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_up) {
            this.arm.setPosition(this.arm.getPosition()+0.01);
        } else if (gamepad1.dpad_down) {
            this.arm.setPosition(this.arm.getPosition()-0.01);
        }
        telemetry.addData("Arm position: ", this.arm.getPosition());
        telemetry.update();
    }
}
