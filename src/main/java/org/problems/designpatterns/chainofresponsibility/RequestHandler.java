package org.problems.designpatterns.chainofresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestHandler extends Handler {

    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);

    @Override
    public boolean handle(Request request) {
        log.info("Request is handled");
        return null == next || next.handle(request);
    }
}
