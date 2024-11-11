package it.ji.patterns.state.live.statemachine;

public interface StateEvent {
    void apply(Task task);
}
