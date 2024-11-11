package it.ji.patterns.state.live.chadstate.exceptions;

public class InvalidTransitionException extends Exception{

    public InvalidTransitionException(String message) {
        super(message);
    }
}
