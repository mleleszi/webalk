package hu.me.iit.webalk.springConsoleApp.impl;

import hu.me.iit.webalk.springConsoleApp.Wheel;

public class WheelImpl implements Wheel {

    private final int width;
    private final int diameter;

    public WheelImpl(int width, int diameter) {
        this.width = width;
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "width=" + width +
                ", diameter=" + diameter +
                '}';
    }
}
