package it.ji.patterns.command.live.client;

import it.ji.patterns.command.live.commands.Command;

import java.util.*;

public class Controller {

    public enum Buttons {
        BUTTON_1,
        BUTTON_2,
        BUTTON_3,
        BUTTON_4,
        UNDO
    }

    //Una EnumMap è da preferire perché usa un array internamente dato che le chiavi sono definite e si conoscono
    //a priori.
    private Map<Buttons, Optional<Command>> commands = new EnumMap<>(Buttons.class);
    private List<Command> history = new ArrayList<>();

    public void configureButton(Buttons button, Command command) {
        commands.put(button, Optional.of(command));
    }

    public void pressButton(Buttons button) {
        commands.get(button).ifPresent(Command::execute);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.get(history.size() - 1);
            lastCommand.undo();
            history.remove(lastCommand);
        }
    }
}
