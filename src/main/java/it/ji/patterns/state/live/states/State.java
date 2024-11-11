package it.ji.patterns.state.live.states;

import it.ji.patterns.state.live.Task;

public interface State {
    //ogni metodo rappresenta un'azione possibile sullo stato e l'eventuale passaggio ad un altro stato
    //sarà compito della classe Task implementare questi metodi
    void startWorking(Task task);
    void endWorking(Task task);
    void startTesting(Task task);
    void testFailed(Task task);
    void testPassed(Task task);
}
