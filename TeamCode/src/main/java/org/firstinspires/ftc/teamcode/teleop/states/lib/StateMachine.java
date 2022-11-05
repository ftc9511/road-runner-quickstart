package org.firstinspires.ftc.teamcode.teleop.states.lib;

import org.firstinspires.ftc.teamcode.teleop.controllers.RobotController;

import java.util.Stack;

public class StateMachine {
    private Stack<RobotState> states;
    private RobotController controller;
    private RobotState previous_state;

    public StateMachine(RobotState start_state, RobotController controller) {
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
        this.controller.telemetry.addData("States: ", this.states);
        this.controller.telemetry.addData("Current State: ", this.currentState());

        RobotState state;
        try {
            // Get the new state
            state = this.currentState().loop();
        } catch (NoNewStateException e) {
            // Fall back to previous state
            this.states.pop();
            state = this.currentState();
        }
        if (state != this.currentState()) {
            // If the state has changed, we need to run it's enter method
            state.enter(this.controller);
        }
    }
}