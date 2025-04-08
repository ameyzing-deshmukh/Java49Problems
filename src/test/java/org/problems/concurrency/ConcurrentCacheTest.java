package org.problems.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ConcurrentCacheTest {

    @Test
    public void testCacheOperations() throws InterruptedException {
        ConcurrentCache<Integer, String> cache = new ConcurrentCache<>(7);
        ExecutorService service = Executors.newFixedThreadPool(7);

        //Writing into cache
        service.execute(() -> {
            for (int i = 1; i < 8; i++) {
                cache.put(i, "Value" + i);
                System.out.println("Inserted: " + i);
            }
        });

        //Reading from cache
        service.execute(() -> {
            for (int i = 1; i < 7; i++) {
                System.out.println("Recent cache value: " + cache.get(i));
            }
        });
        service.shutdown();
        service.awaitTermination(20, TimeUnit.SECONDS);
    }

}