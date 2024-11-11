package it.ji.patterns.state.live.statemachine;

public class Task {
    private final String name;
    private String currentState = null;

    public Task(String name) {
        this.name = name;
        this.currentState = "TODO";
    }

    public void applyEvent(String event) {
        System.out.println("Applying event: " + event);
        TaskStateMachine.getInstance().applyEvent(event, currentState);
    }

    public String getState() {
        return currentState;
    }

    public String getName() {
        return name;
    }
}

