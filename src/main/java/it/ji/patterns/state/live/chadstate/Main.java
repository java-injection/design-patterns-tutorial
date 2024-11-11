package it.ji.patterns.state.live.chadstate;

import it.ji.patterns.state.live.chadstate.exceptions.InvalidTransitionException;
import it.ji.patterns.state.live.chadstate.manager.Task;
import it.ji.patterns.state.live.chadstate.states.TaskEvent;
import it.ji.patterns.state.live.chadstate.states.TaskState;

import static it.ji.patterns.state.live.chadstate.manager.TransitionMatrixFactory.withCustomTransitions;
import static it.ji.patterns.state.live.chadstate.manager.TransitionMatrixFactory.withDefaults;
import static it.ji.patterns.state.live.chadstate.manager.TransitionMatrixFactory.Transition;

public class Main {

    public static void main(String[] args) {
        //Testing the chad state pattern
        Task task1 = new Task("Test Chad State Patterns 1", withDefaults());
        Task task2 = new Task("Test Chad State Patterns 2", withCustomTransitions(
                new Transition(TaskState.TODO, TaskEvent.START_WORKING, t -> TaskState.IN_PROGRESS),
                new Transition(TaskState.IN_PROGRESS, TaskEvent.END_WORKING, t -> TaskState.DONE)
        ));

        System.out.println("Task: " + task2.getName() + " is in state: " + task2.getCurrentState());
        try {
            task2.handleEvent(TaskEvent.START_WORKING);
            System.out.println("Task: " + task2.getName() + " is in state: " + task2.getCurrentState());
            task2.handleEvent(TaskEvent.END_WORKING);
            System.out.println("Task: " + task2.getName() + " is in state: " + task2.getCurrentState());
            //test invalid state
            task2.handleEvent(TaskEvent.START_WORKING);
            System.out.println("Task: " + task2.getName() + " is in state: " + task2.getCurrentState());

        } catch (InvalidTransitionException e) {
            System.err.println(e.getMessage());
        }
    }
}
