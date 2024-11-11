package it.ji.patterns.state.live.statemachine;

import java.util.HashMap;
import java.util.Map;

public class TaskStateMachine {
    private final Map<String, Map<String, String>> stateTransitions = new HashMap<>();

    private static TaskStateMachine INSTANCE = null;

    public static TaskStateMachine getInstance() {
        if (INSTANCE == null) {
            return new TaskStateMachine();
        }
        return INSTANCE;
    }

    private TaskStateMachine() {
        // Definisce tutte le transizioni valide
        addTransition("TODO", "startWorking", "IN_PROGRESS");
        addTransition("IN_PROGRESS", "endWorking", "DONE");
        addTransition("IN_PROGRESS", "startTesting", "TESTING");
        addTransition("TESTING", "testFailed", "IN_PROGRESS");
        addTransition("TESTING", "testPassed", "DONE");
    }

    private void addTransition(String fromState, String event, String toState) {
        stateTransitions
                .computeIfAbsent(fromState, k -> new HashMap<>())
                .put(event, toState);
    }

    public String applyEvent(String event, String currentState) {
        Map<String, String> transitions = stateTransitions.get(currentState);
        if (transitions != null && transitions.containsKey(event)) {
            String newState = transitions.get(event);
            System.out.println("State changed to: " + newState);
            return newState;
        } else {
            throw new IllegalArgumentException("Invalid event '" + event + "' for state '" + currentState + "'");
        }
    }

}

