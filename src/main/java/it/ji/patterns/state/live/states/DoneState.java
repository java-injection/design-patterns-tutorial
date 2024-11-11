package it.ji.patterns.state.live.states;

import it.ji.patterns.state.live.Task;

public class DoneState implements State {

    @Override
    public void startWorking(Task task) {
        throw new IllegalArgumentException("Operation not allowed in DONE state.");
    }

    @Override
    public void endWorking(Task task) {
        throw new IllegalArgumentException("Operation not allowed in DONE state.");
    }

    @Override
    public void startTesting(Task task) {
        throw new IllegalArgumentException("Operation not allowed in DONE state.");
    }

    @Override
    public void testFailed(Task task) {
        throw new IllegalArgumentException("Operation not allowed in DONE state.");
    }

    @Override
    public void testPassed(Task task) {
        throw new IllegalArgumentException("Operation not allowed in DONE state.");
    }
}
