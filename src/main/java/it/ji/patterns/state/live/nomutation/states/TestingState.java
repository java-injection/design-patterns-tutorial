package it.ji.patterns.state.live.nomutation.states;

import it.ji.patterns.state.live.nomutation.Task;

public class TestingState implements State {

    private Task task;

    public TestingState(Task task) {
        this.task = task;
    }

    @Override
    public Task startWorking() {
        throw new IllegalArgumentException("Operation not allowed in TESTING state.");
    }

    @Override
    public Task endWorking() {
        throw new IllegalArgumentException("Operation not allowed in TESTING state.");
    }

    @Override
    public Task startTesting() {
        throw new IllegalArgumentException("Operation not allowed in TESTING state.");
    }

    @Override
    public Task testFailed() {
        System.out.println("Task '" + task.getName() + "' failed testing.");
        return task.withState(new InProgressState(this.task));
    }

    @Override
    public Task testPassed() {
        System.out.println("Task '" + task.getName() + "' passed testing.");
        return task.withState(new DoneState());
    }
}
