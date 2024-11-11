package it.ji.patterns.state.live.statemachine;

public class Task {
    private final String name;
    private final TaskStateMachine stateMachine;

    public Task(String name) {
        this.name = name;
        this.stateMachine = new TaskStateMachine();
    }

    public void applyEvent(String event) {
        System.out.println("Applying event: " + event);
        stateMachine.applyEvent(event);
    }

    public String getState() {
        return stateMachine.getCurrentState();
    }

    public String getName() {
        return name;
    }
}

