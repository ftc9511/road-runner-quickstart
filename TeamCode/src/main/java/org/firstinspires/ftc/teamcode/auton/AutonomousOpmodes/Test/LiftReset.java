package org.firstinspires.ftc.teamcode.auton.AutonomousOpmodes.Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class LiftReset extends OpMode {
    protected DcMotorEx lift;
    @Override
    public void init() {
        lift = hardwareMap.get(DcMotorEx.class, "lift");
        lift.setTargetPosition(lift.getCurrentPosition());
        lift.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        lift.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_up){
            lift.setPower(-1);
            lift.setTargetPosition(lift.getTargetPosition() - 50);  // 50 is a very arbitrary value; subject to change
        }
        if (gamepad1.dpad_down){
            lift.setPower(1);
            lift.setTargetPosition(lift.getTargetPosition() + 50);
        }
    }
}
