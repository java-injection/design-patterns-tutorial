package it.ji.patterns.state.live.statemachine;

import java.util.HashMap;
import java.util.Map;

public class TaskStateMachine {
    private String currentState;
    private final Map<String, Map<String, String>> stateTransitions = new HashMap<>();

    public TaskStateMachine() {
        // Definisce tutte le transizioni valide
        addTransition("TODO", "startWorking", "IN_PROGRESS");
        addTransition("IN_PROGRESS", "endWorking", "DONE");
        addTransition("IN_PROGRESS", "startTesting", "TESTING");
        addTransition("TESTING", "testFailed", "IN_PROGRESS");
        addTransition("TESTING", "testPassed", "DONE");

        // Imposta lo stato iniziale
        this.currentState = "TODO";
    }

    private void addTransition(String fromState, String event, String toState) {
        stateTransitions
                .computeIfAbsent(fromState, k -> new HashMap<>())
                .put(event, toState);
    }

    public void applyEvent(String event) {
        Map<String, String> transitions = stateTransitions.get(currentState);
        if (transitions != null && transitions.containsKey(event)) {
            currentState = transitions.get(event);
            System.out.println("State changed to: " + currentState);
        } else {
            System.out.println("Invalid event '" + event + "' in state '" + currentState + "'");
        }
    }

    public String getCurrentState() {
        return currentState;
    }
}

