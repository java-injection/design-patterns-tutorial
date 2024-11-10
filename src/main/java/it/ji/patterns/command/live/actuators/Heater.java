package it.ji.patterns.command.live.actuators;

public class Heater {

    private boolean on;

    public void switchOn() {
        on = true;
        System.out.println("Heater switched on");
    }

    public void switchOff() {
        on = false;
        System.out.println("Heater switched off");
    }

    public boolean isOn() {
        return on;
    }
}
