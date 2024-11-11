package it.ji.patterns.state.live.states;

import it.ji.patterns.state.live.Task;

public class TestingState implements State {

    @Override
    public void startWorking(Task task) {
        throw new IllegalArgumentException("Operation not allowed in TESTING state.");
    }

    @Override
    public void endWorking(Task task) {
        throw new IllegalArgumentException("Operation not allowed in TESTING state.");
    }

    @Override
    public void startTesting(Task task) {
        throw new IllegalArgumentException("Operation not allowed in TESTING state.");
    }

    @Override
    public void testFailed(Task task) {
        System.out.println("Task '" + task.getName() + "' failed the test.");
        task.setState(new InProgressState());
    }

    @Override
    public void testPassed(Task task) {
        System.out.println("Task '" + task.getName() + "' passed the test.");
        task.setState(new DoneState());
    }
}
