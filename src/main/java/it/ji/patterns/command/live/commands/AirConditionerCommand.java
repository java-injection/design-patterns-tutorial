package it.ji.patterns.command.ex1.commands;

import it.ji.patterns.command.ex1.actuators.AirConditioner;

public class AirConditionerCommand implements Command {

    private AirConditioner airConditioner;

    public AirConditionerCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.nextMode();
    }

    @Override
    public void undo() {
        airConditioner.previousMode();
    }
}