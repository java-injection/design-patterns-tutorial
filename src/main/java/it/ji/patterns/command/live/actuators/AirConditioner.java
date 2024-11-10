package it.ji.patterns.command.live.actuators;

public class AirConditioner {

    public enum Mode {
        HEAT, COOL, FAN, AUTO, OFF
    }

    private int currentMode = 4;


    public AirConditioner() {
        this.currentMode = Mode.OFF.ordinal();
    }

    public void nextMode() {
        this.currentMode = (this.currentMode + 1) % Mode.values().length;
    }

    public void previousMode() {
        this.currentMode = (this.currentMode - 1 + Mode.values().length) % Mode.values().length;
    }

    public Mode getCurrentMode() {
        return Mode.values()[this.currentMode];
    }


}
