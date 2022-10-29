package org.firstinspires.ftc.teamcode.teleop.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Test Servo Teleop")
public class TestOpMode extends OpMode  {
    private Servo left_servo;
    private Servo right_servo;

    private int LEFT_OPEN = 0;
    private double LEFT_CLOSED = 0.4;
    private int RIGHT_OPEN = 1;
    private double RIGHT_CLOSED = 0.6;


    @Override
    public void init() {
        this.left_servo = hardwareMap.get(Servo.class, "left_claw");
        this.right_servo = hardwareMap.get(Servo.class, "right_claw");
        //
    }

    @Override
    public void loop() {
//        this.left_servo.setPosition(gamepad1.left_stick_x);
        if (gamepad1.a){
            this.left_servo.setPosition(0.3);
            this.right_servo.setPosition(0.7);
        }
        if (gamepad1.b){
            this.left_servo.setPosition(0);
            this.right_servo.setPosition(1);
        }
        telemetry.addData("left_servo", this.left_servo.getPosition());
        telemetry.addData("right_servo", this.right_servo.getPosition());
        telemetry.update();
    }
}
