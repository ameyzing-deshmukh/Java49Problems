package org.problems.corejava;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class MyCloseableResourceTest {


    private static final Logger log = LoggerFactory.getLogger(MyCloseableResourceTest.class);

    @Test
    public void testResourceLifecycle() {
        Exception thrownException = null;
        try (MyCloseableResource resource = new MyCloseableResource()) {
            resource.doSomething();
        } catch (Exception e) {
            log.info("Exception caught: {}", e.getMessage());
            thrownException = e;
        }
        log.info("resource is closed after exception is caught");
        assertNotNull(thrownException, "Exception should be thrown from close() method");
        assertEquals("Exception thrown explicitly from close() method", thrownException.getMessage(), "Exception message should match");
    }

}