package org.problems.concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteDemo {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static String currentValue = "Initial value";

    static class Reader implements Runnable {

        private final int id;

        Reader(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            lock.readLock().lock();
            try {
                System.out.println("Reader Thread " + Thread.currentThread().getName() + " with id: " + id + " is reading " + currentValue);
                Thread.sleep(500);//Simulate reading
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.readLock().unlock();
            }
        }
    }

    static class Writer implements Runnable {
        private final int id;
        private final String newValue;

        Writer(int id, String newValue) {
            this.id = id;
            this.newValue = newValue;
        }

        @Override
        public void run() {
            lock.writeLock().lock();
            try {
                currentValue = newValue;
                System.out.println("Writer Thread " + Thread.currentThread().getName() + " with id: " + id + " is modifying data to: " + newValue);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        Thread rt1 = new Thread(new Reader(1));
        Thread rt2 = new Thread(new Reader(2));
        Thread wt1 = new Thread(new Writer(1, "First New Value"));
        Thread rt3 = new Thread(new Reader(3));
        Thread wt2 = new Thread(new Writer(2, "Second New Value"));

        rt1.start();
        rt2.start();
        wt1.start();
        rt3.start();
        wt2.start();

        try {
            rt1.join();
            rt2.join();
            wt1.join();
            rt3.join();
            wt2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All read and write operations are done.");
    }
}
