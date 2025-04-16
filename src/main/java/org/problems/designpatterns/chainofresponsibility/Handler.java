package org.problems.designpatterns.chainofresponsibility;

public abstract class Handler {

    protected Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(Request request);
}
