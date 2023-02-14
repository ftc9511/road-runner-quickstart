package org.firstinspires.ftc.teamcode.teleop.controllers;

import java.util.ArrayList;
import java.util.List;

public class JunctionLevelController {
    private LinearSlideController controller;
    private ArrayList<Integer> junctionTicks;
    private int current;

    public JunctionLevelController(LinearSlideController controller) {
        this.controller = controller;
        this.junctionTicks = new ArrayList<Integer>();
        this.junctionTicks.add(this.controller.RETRACT_TICKS);
        this.junctionTicks.add(1679);
        this.junctionTicks.add(2820);
        this.junctionTicks.add(3944);
        this.current = junctionTicks.get(0);
    }

    public void next() {
        if (!(this.current == junctionTicks.get(junctionTicks.size() - 1))) {
            this.current = junctionTicks.get(junctionTicks.indexOf(this.current) + 1);
            // this.controller.toPosition(this.current);
        }
    }

    public void back() {
        if (!(this.current == junctionTicks.get(0))) {
            this.current = junctionTicks.get(junctionTicks.indexOf(this.current) - 1);
            // this.controller.toPosition(this.current);
        }
    }
}
