package com.digis.quwi.test.domain.states;


public class ErrorState extends State {

    private final Throwable throwable;

    public ErrorState(Throwable throwable) {
        throwable.printStackTrace();
        this.throwable = throwable;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
