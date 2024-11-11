package it.ji.patterns.state.live.nomutation.states;

import it.ji.patterns.state.live.nomutation.Task;

public class InProgressState implements State {
    private Task task;

    public InProgressState(Task task) {
        this.task = task;
    }

    @Override
    public Task startWorking() {
        throw new IllegalArgumentException("Operation not allowed in IN PROGRESS state.");
    }

    @Override
    public Task endWorking() {
        System.out.println("Task '" + task.getName() + "' is now in testing.");
        return task.withState(new TestingState(this.task));
    }

    @Override
    public Task startTesting() {
        throw new IllegalArgumentException("Operation not allowed in IN PROGRESS state.");
    }

    @Override
    public Task testFailed() {
        throw new IllegalArgumentException("Operation not allowed in IN PROGRESS state.");
    }

    @Override
    public Task testPassed() {
        throw new IllegalArgumentException("Operation not allowed in IN PROGRESS state.");
    }
}
