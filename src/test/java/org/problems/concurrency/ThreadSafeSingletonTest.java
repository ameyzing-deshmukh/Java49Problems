package org.problems.concurrency;

import org.junit.jupiter.api.Test;

class ThreadSafeSingletonTest {

    @Test
    public void testThreadSafeSingletonCreation() {
        Runnable task = () -> {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
            System.out.println("Hashcode- " + singleton.hashCode());
            System.out.println(singleton.getValue());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread3.start();
        thread2.start();
    }

}