package it.ji.patterns.state.live.chadstate.manager;

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

    public void handleEvent(TaskEvent event) {
        transitionMatrix.getTransition(currentState, event).ifPresentOrElse(
                transition -> {
                    currentState = transition.execute(this);
                },
                () -> System.out.println("No transition found for event " + event + " in state " + currentState)
        );
    }


    public String getName() {
        return name;
    }

    public TaskState getCurrentState() {
        return currentState;
    }
}
