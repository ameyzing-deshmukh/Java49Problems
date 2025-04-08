package org.problems.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CustomBlockingQueue {
    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

}

class Producer implements Runnable {
    int id;

    Producer(int id) {
        this.id = id;
    }

    @Override
    public void run() {
//        synchronized (Producer.class) {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(CustomBlockingQueue.queue.toString());
                int e = i + (id * 10);
                CustomBlockingQueue.queue.put(e);
                System.out.println("Producer " + id + " produced: " + e);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
//        }
    }
}

class Consumer implements Runnable {
    int id;

    Consumer(int id) {
        this.id = id;
    }

    @Override
    public void run() {
//        synchronized (Consumer.class) {
        try {
            while (true) {
                System.out.println(CustomBlockingQueue.queue.toString());
                int value = CustomBlockingQueue.queue.take();
                System.out.println("Consumer " + id + " consumed: " + value);
                Thread.sleep(100000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
//        }
    }
}

