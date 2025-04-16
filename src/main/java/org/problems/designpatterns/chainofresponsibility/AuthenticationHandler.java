package org.problems.designpatterns.chainofresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationHandler extends Handler {
    Logger logger = LoggerFactory.getLogger(AuthenticationHandler.class);

    @Override
    public boolean handle(Request request) {
        if (null == request.getUser() || request.getUser().isEmpty()) {
            logger.info("Request is unauthenticated");
            return false;
        }
        request.setAuthenticated(true);
        logger.info("Handled Authentication");
        return null == next || next.handle(request);
    }
}
