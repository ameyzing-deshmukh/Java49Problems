package org.problems.concurrency;

import org.junit.jupiter.api.Test;

class CustomBlockingQueueTest {

    @Test
    public void testProducerAndConsumer() {

        Thread producer1 = new Thread(new Producer(1));
        Thread producer2 = new Thread(new Producer(2));

        Thread consumer1 = new Thread(new Consumer(1));
        Thread consumer2 = new Thread(new Consumer(2));

        producer1.start();
        producer2.start();

        consumer1.start();
        consumer2.start();
    }

}