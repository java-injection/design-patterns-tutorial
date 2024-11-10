package it.ji.patterns.command.live.commands;

import it.ji.patterns.command.live.actuators.Heater;

public class HeaterCommand implements Command {
    private Heater heater;

    public HeaterCommand(Heater heater) {
        this.heater = heater;
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
        if (heater.isOn()) {
            heater.switchOff();
        } else {
            heater.switchOn();
        }
    }
}
