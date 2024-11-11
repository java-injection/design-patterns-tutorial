package it.ji.patterns.state.live.nomutation.states;

import it.ji.patterns.state.live.nomutation.Task;

public class DoneState implements State {

    @Override
    public Task startWorking() {
        throw new IllegalArgumentException("Operation not allowed in DONE state.");
    }

    @Override
    public Task endWorking() {
        throw new IllegalArgumentException("Operation not allowed in DONE state.");
    }

    @Override
    public Task startTesting() {
        throw new IllegalArgumentException("Operation not allowed in DONE state.");
    }

    @Override
    public Task testFailed() {
        throw new IllegalArgumentException("Operation not allowed in DONE state.");
    }

    @Override
    public Task testPassed() {
        throw new IllegalArgumentException("Operation not allowed in DONE state.");
    }
}
