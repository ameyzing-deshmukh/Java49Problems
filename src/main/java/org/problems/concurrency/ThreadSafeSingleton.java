package org.problems.concurrency;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;
    private final int value;

    private ThreadSafeSingleton() {
        System.out.println("Instance created.");
        value = 5;
    }

    public int getValue() {
        return value;
    }

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
