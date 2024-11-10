package it.ji.patterns.command.ex1.commands;

import it.ji.patterns.command.ex1.actuators.Light;

public class LightCommand implements Command {

    private Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        switchStatus();
    }

    @Override
    public void undo() {
        switchStatus();
    }

    private void switchStatus() {
        if (light.isOn()) {
            light.switchOff();
        } else {
            light.switchOn();
        }
    }
}
