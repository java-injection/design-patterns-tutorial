package it.ji.patterns.command.ex1.commands;

import it.ji.patterns.command.ex1.actuators.Heater;

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