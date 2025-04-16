package org.problems.designpatterns.chainofresponsibility;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChainOfResponsibilityTest {

    @Test
    public void testRequests() {
        Handler authenticationHandler = new AuthenticationHandler();
        Handler autharizationHandler = new AuthorizationHandler();
        Handler validityHandler = new ValidityHandler();
        Handler requestHandler = new RequestHandler();

        authenticationHandler.setNext(autharizationHandler).setNext(validityHandler).setNext(requestHandler);

        Request allGoodRequest = new Request("Amey", "Admin", "yes payload");
        assertTrue(authenticationHandler.handle(allGoodRequest));

        Request invalidRequest = new Request("Amey", "Admin", "");
        assertFalse(authenticationHandler.handle(invalidRequest));

        Request unauthorizedRequest = new Request("Amey", "", "");
        assertFalse(authenticationHandler.handle(unauthorizedRequest));

        Request unauthenticatedRequest = new Request("", "", "");
        assertFalse(authenticationHandler.handle(unauthenticatedRequest));
    }

}