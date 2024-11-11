package it.ji.patterns.state.live.states;

import it.ji.patterns.state.live.Task;

public class TodoState implements State {

    @Override
    public void startWorking(Task task) {
        System.out.println("Task '" + task.getName() + "' is now in progress.");
        task.setState(new InProgressState());
    }

    @Override
    public void endWorking(Task task) {
        throw new IllegalArgumentException("Operation not allowed in TODO state.");
    }

    @Override
    public void startTesting(Task task) {
        throw new IllegalArgumentException("Operation not allowed in TODO state.");
    }

    @Override
    public void testFailed(Task task) {
        throw new IllegalArgumentException("Operation not allowed in TODO state.");
    }

    @Override
    public void testPassed(Task task) {
        throw new IllegalArgumentException("Operation not allowed in TODO state.");
    }
}

