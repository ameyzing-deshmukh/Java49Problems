package org.problems.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCache<K, V> {
    ConcurrentHashMap<K, V> cache;
    private final int maxSize;

    public ConcurrentCache(int maxSize) {
        this.cache = new ConcurrentHashMap();
        this.maxSize = maxSize;
    }

    public void put(K key, V value) {
        if (cache.size() >= maxSize) {
            evict(key);
        }
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    private void evict(K key) {
        K keyToEvict = cache.keys().nextElement();
        cache.remove(keyToEvict);
    }
}
