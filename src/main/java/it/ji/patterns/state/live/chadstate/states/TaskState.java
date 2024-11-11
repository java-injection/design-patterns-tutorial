package it.ji.patterns.state.live.chadstate.states;

public enum TaskState {
    TODO("Todo"),
    IN_PROGRESS("In Progress"),
    TESTING("Testing"),
    DONE("Done");

    private String name;

    private TaskState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
