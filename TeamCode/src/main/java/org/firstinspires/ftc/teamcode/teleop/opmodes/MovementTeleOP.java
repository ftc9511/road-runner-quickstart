package org.firstinspires.ftc.teamcode.teleop.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.teleop.base.BaseTeleOP;
import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;
import org.firstinspires.ftc.teamcode.teleop.states.RobotMovingState;
import org.firstinspires.ftc.teamcode.teleop.states.lib.StateMachine;

@TeleOp(name="[FSM] 9511 Movement TeleOP")
public class MovementTeleOP extends BaseTeleOP {
    @Override
    public void init() {
        this.machine = new StateMachine(new RobotMovingState(), new RobotController(this.hardwareMap, this.telemetry, this.gamepad1));
    }
}
