package it.ji.patterns.command.ex1.actuators;

public class Light {
    private boolean on;

    public void switchOn() {
        on = true;
        System.out.println("Light switched on");
    }

    public void switchOff() {
        on = false;
        System.out.println("Light switched off");
    }

    public boolean isOn() {
        return on;
    }
}
