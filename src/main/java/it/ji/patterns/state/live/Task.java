package it.ji.patterns.state.live;

import it.ji.patterns.state.live.states.State;
import it.ji.patterns.state.live.states.TodoState;

public class Task {

    private String name;

    private State state;

    public Task(String name) {
        this.name = name;
        this.state = new TodoState();
    }

    public String getName() {
        return name;
    }

    public void startWorking() {
        state.startWorking(this);
    }

    public void endWorking() {
        state.endWorking(this);
    }

    public void startTesting() {
        state.startTesting(this);
    }

    public void testFailed() {
        state.testFailed(this);
    }

    public void testPassed() {
        state.testPassed(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }


    public String getStateName() {
        return state.getClass().getSimpleName();
    }
}
