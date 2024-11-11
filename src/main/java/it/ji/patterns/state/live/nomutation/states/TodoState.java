package it.ji.patterns.state.live.nomutation.states;

import it.ji.patterns.state.live.nomutation.Task;

public class TodoState implements State {
    private Task task;

    public TodoState(Task task) {
        this.task = task;
    }

    @Override
    public Task startWorking() {
        System.out.println("Task '" + task.getName() + "' is now in progress.");
        return task.withState(new InProgressState(this.task));
    }

    @Override
    public Task endWorking() {
        throw new IllegalArgumentException("Operation not allowed in TODO state.");
    }

    @Override
    public Task startTesting() {
        throw new IllegalArgumentException("Operation not allowed in TODO state.");
    }

    @Override
    public Task testFailed() {
        throw new IllegalArgumentException("Operation not allowed in TODO state.");
    }

    @Override
    public Task testPassed() {
        throw new IllegalArgumentException("Operation not allowed in TODO state.");
    }
}

