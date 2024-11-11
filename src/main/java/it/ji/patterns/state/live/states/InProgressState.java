package it.ji.patterns.state.live.states;

import it.ji.patterns.state.live.Task;

public class InProgressState implements State {

    @Override
    public void startWorking(Task task) {
        throw new IllegalArgumentException("Operation not allowed in IN PROGRESS state.");
    }

    @Override
    public void endWorking(Task task) {
        task.setState(new DoneState());
    }

    @Override
    public void startTesting(Task task) {
        System.out.println("Task '" + task.getName() + "' is now in testing.");
        task.setState(new TestingState());
    }

    @Override
    public void testFailed(Task task) {
        throw new IllegalArgumentException("Operation not allowed in IN PROGRESS state.");
    }

    @Override
    public void testPassed(Task task) {
        throw new IllegalArgumentException("Operation not allowed in IN PROGRESS state.");
    }
}
