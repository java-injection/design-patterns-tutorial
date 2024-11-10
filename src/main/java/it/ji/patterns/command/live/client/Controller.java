package it.ji.patterns.command.ex1.house;

import it.ji.patterns.command.ex1.commands.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Controller {
    private House home;

    public enum BUTTONS {
        BUTTON_1,
        BUTTON_2,
        BUTTON_3,
        BUTTON_4,
        ROOM_SELECTOR,
    }

    private HashMap<BUTTONS, Optional<Command>> commands = new HashMap<>();
    private List<Command> history = new ArrayList<>();

    public Controller(House home) {
        this.home = home;
    }

    public void configureButton(BUTTONS button, Command command) {
        commands.put(button, Optional.of(command));
    }

    public void pressButton(BUTTONS button) {
        commands.get(button).ifPresent(Command::execute);
    }

    public void nextRoom(){
        commands.get(BUTTONS.ROOM_SELECTOR).ifPresent(Command::execute);
    }


    public void undo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.get(history.size() - 1);
            lastCommand.undo();
            history.remove(lastCommand);
        }
    }
}
