package it.ji.patterns.state.live.nomutation.states;

import it.ji.patterns.state.live.nomutation.Task;

public interface State {
    Task startWorking();
    Task endWorking();
    Task startTesting();
    Task testFailed();
    Task testPassed();
}

