package it.ji.patterns.state.live.chadstate.manager;

import it.ji.patterns.state.live.chadstate.states.StateTransition;
import it.ji.patterns.state.live.chadstate.states.TaskEvent;
import it.ji.patterns.state.live.chadstate.states.TaskState;

public class TransitionMatrixFactory {

    public static TransitionMatrix withDefaults() {
        TransitionMatrix matrix = new TransitionMatrix();
        matrix.addTransition(TaskState.TODO, TaskEvent.START_WORKING, task -> TaskState.IN_PROGRESS);
        matrix.addTransition(TaskState.IN_PROGRESS, TaskEvent.END_WORKING, task -> TaskState.DONE);
        matrix.addTransition(TaskState.IN_PROGRESS, TaskEvent.START_TESTING, task -> TaskState.TESTING);
        matrix.addTransition(TaskState.TESTING, TaskEvent.TEST_FAILED, task -> TaskState.IN_PROGRESS);
        matrix.addTransition(TaskState.TESTING, TaskEvent.TEST_PASSED, task -> TaskState.DONE);
        return matrix;
    }

    public static TransitionMatrix withCustomTransitions(Transition ... transitions) {
        TransitionMatrix matrix = new TransitionMatrix();
        for (Transition transition : transitions) {
            matrix.addTransition(transition.from(), transition.event(), transition.transition());
        }
        return matrix;
    }

    public record Transition(TaskState from, TaskEvent event, StateTransition transition) {}

}
