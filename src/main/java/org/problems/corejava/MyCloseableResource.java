package org.problems.corejava;

import java.util.logging.Logger;

public class MyCloseableResource implements AutoCloseable {

    private final Logger logger = Logger.getLogger(MyCloseableResource.class.getName());

    public MyCloseableResource() {
        logger.info("My resource is initialised.");
    }

    @Override
    public void close() throws Exception {
        logger.info("Close method is invoked");
        throw new Exception("Exception thrown explicitly from close() method");
    }

    public void doSomething() {
        logger.info("Doing something");
    }
}
