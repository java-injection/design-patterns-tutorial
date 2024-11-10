package it.ji.patterns.command.live.commands;

public interface Command {
    void execute();
    void undo();
}
