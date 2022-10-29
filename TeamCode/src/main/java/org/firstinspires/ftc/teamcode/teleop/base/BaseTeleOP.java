package org.firstinspires.ftc.teamcode.teleop.base;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.RobotIdleState;
import org.firstinspires.ftc.teamcode.teleop.states.lib.StateMachine;


@TeleOp(name = "(9511) BaseTeleOP")
public class BaseTeleOP extends BaseRobot {

    @Override
    public void init() {
        this.machine = new StateMachine(new RobotIdleState(), new RobotController(this.hardwareMap, this.telemetry, this.gamepad1));
    }

    @Override
    public void loop() {
        this.machine.run();
    }
}