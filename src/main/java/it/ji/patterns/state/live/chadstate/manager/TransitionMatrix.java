package it.ji.patterns.state.live.chadstate.manager;

import it.ji.patterns.state.live.chadstate.states.StateTransition;
import it.ji.patterns.state.live.chadstate.states.TaskEvent;
import it.ji.patterns.state.live.chadstate.states.TaskState;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class TransitionMatrix {

    // This is a map of maps. The outer map is keyed by the state to transition from.
    // The inner map is keyed by the event that triggers the transition.
    // The value of the inner map is the transition to execute
    private final Map<TaskState, Map<TaskEvent, StateTransition>> transitions;

    public TransitionMatrix() {
        transitions = new EnumMap<>(TaskState.class);
    }

    /**
     * Add a transition to the matrix
     * @param from the state to transition from
     * @param event the event that triggers the transition
     * @param transition the transition to execute
     */
    public void addTransition(TaskState from, TaskEvent event, StateTransition transition) {
        transitions
                .computeIfAbsent(from, k -> new EnumMap<>(TaskEvent.class))
                .put(event, transition);
    }

    public Optional<StateTransition> getTransition(TaskState from, TaskEvent event) {
    return Optional.ofNullable(transitions.get(from))
                   .map(eventMap -> eventMap.get(event));
}
}
