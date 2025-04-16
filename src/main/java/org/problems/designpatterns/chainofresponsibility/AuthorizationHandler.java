package org.problems.designpatterns.chainofresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorizationHandler extends Handler {
    Logger logger = LoggerFactory.getLogger(AuthorizationHandler.class);

    @Override
    public boolean handle(Request request) {
        if (null == request.getRole() || request.getRole().isEmpty()) {
            logger.info("Request is unauthorized");
            return false;
        }
        request.setAutharized(true);
        logger.info("Handled Authorization");
        return null == next || next.handle(request);
    }
}
