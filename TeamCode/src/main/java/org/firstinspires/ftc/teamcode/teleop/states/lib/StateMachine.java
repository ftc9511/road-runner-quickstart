package org.firstinspires.ftc.teamcode.teleop.states.lib;

import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;

import java.util.Stack;

public class StateMachine {
    private Stack<RobotState> states;
    private RobotController controller;
    private RobotState previous_state;
    private int currentStateTicks;

    public StateMachine(RobotState start_state, RobotController controller) {
        this.currentStateTicks = 0;
        this.controller = controller;
        this.states = new Stack<RobotState>();
        this.states.push(start_state);
        this.controller.telemetry.addData("Initializing state machine with state ", this.currentState().getClass().getName());
        this.previous_state = this.currentState();
    }

    private RobotState currentState() {
        return this.states.peek();
    }

    public void run() {
        // Run loop on our state
        // If we have a new state, we need to push this to our stack and then run it's enter method
        this.controller.telemetry.addData("States: ", this.states);
        this.controller.telemetry.addData("Current State: ", this.currentState());

        try {
            RobotState new_state = this.currentState().loop(this.controller);
            if (this.previous_state != new_state) {
                // if the state has changed
                this.states.push(new_state);
                this.currentState().enter(this.controller);
            }
            this.previous_state = this.currentState();

        } catch (NoNewStateException e) {
            // Fall back to previous state
            this.states.pop();
        }
    }
}