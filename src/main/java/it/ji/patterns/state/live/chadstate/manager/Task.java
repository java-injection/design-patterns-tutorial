package it.ji.patterns.state.live.chadstate.manager;

import it.ji.patterns.state.live.chadstate.exceptions.InvalidTransitionException;
import it.ji.patterns.state.live.chadstate.states.StateTransition;
import it.ji.patterns.state.live.chadstate.states.TaskEvent;
import it.ji.patterns.state.live.chadstate.states.TaskState;

public class Task {

    private String name;
    private TransitionMatrix transitionMatrix;
    private TaskState currentState;


    public Task(String name, TransitionMatrix transitionMatrix) {
        this.name = name;
        this.transitionMatrix = transitionMatrix;
        this.currentState = TaskState.TODO;
    }

    public void handleEvent(TaskEvent event) throws InvalidTransitionException {
        StateTransition transition = transitionMatrix
                .getTransition(currentState, event)
                .orElseThrow(() -> new InvalidTransitionException(
                        "Invalid transition from state " + currentState + " with event " + event
                ));

        // Esegui la transizione se trovata
        currentState = transition.execute(this);
    }



    public String getName() {
        return name;
    }

    public TaskState getCurrentState() {
        return currentState;
    }
}
