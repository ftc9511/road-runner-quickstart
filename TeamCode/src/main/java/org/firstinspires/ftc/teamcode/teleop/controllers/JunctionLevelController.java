package org.firstinspires.ftc.teamcode.teleop.controllers;

import java.util.List;

public class JunctionLevelController {
    private LinearSlideController controller;
    private List<Integer> junctionTicks;
    private int current;

    public JunctionLevelController(LinearSlideController controller) {
        this.controller = controller;
        this.current = junctionTicks.get(0);
    }

    public void next() {
        if (!(this.current == junctionTicks.get(junctionTicks.size() - 1))) {
            this.current = junctionTicks.get(junctionTicks.indexOf(this.current) + 1);
            this.controller.toPosition(this.current);
        }
    }

    public void back() {
        if (!(this.current == junctionTicks.get(0))) {
            this.current = junctionTicks.get(junctionTicks.indexOf(this.current) - 1);
            this.controller.toPosition(this.current);
        }
    }
}
