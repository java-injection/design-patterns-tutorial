package it.ji.patterns.state.live.chadstate.states;

import it.ji.patterns.state.live.chadstate.manager.Task;

import java.util.function.Consumer;

@FunctionalInterface
public interface StateTransition {

    TaskState execute(Task task);

    default StateTransition withBefore(Consumer<Task> before) {
        return task -> {
            before.accept(task);
            return this.execute(task);
        };
    }

    default StateTransition withAfter(Consumer<Task> after) {
        return task -> {
            TaskState result = this.execute(task);
            after.accept(task);
            return result;
        };
    }
}
