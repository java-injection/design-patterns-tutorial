package it.ji.patterns.state.live.nomutation;

import it.ji.patterns.state.live.nomutation.states.State;
import it.ji.patterns.state.live.nomutation.states.TodoState;

public class Task {

    private final String name;

    private final State state;

    public Task(String name) {
        this.name = name;
        this.state = new TodoState(this);
    }

    public Task(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }


    public String getStateName() {
        return state.getClass().getSimpleName();
    }

    public Task withState(State state) {
        Task task = new Task(name, state);
        return task;
    }
}
