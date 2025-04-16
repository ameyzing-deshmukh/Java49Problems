package org.problems.designpatterns.chainofresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidityHandler extends Handler {
    private static final Logger log = LoggerFactory.getLogger(ValidityHandler.class);

    @Override
    public boolean handle(Request request) {
        if (null == request.getPayload() || request.getPayload().isEmpty()) {
            log.info("Request is invalid");
            return false;
        }
        log.info("Request is validated");
        return null == next || next.handle(request);
    }
}
