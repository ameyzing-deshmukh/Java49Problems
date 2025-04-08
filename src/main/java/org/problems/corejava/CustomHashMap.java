package org.problems.corejava;

import java.util.LinkedList;
import java.util.Objects;

public class CustomHashMap<K, V> {

    public static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public int getIndexForKey(K key) {
        return (key == null) ? 0 : Math.abs(Objects.hash(key) % buckets.length);
    }

    private LinkedList<Entry<K, V>>[] buckets;
    private final Integer DEFAULT_SIZE = 16;
    private int size;
    private double LOAD_FACTOR = 0.75;

    public CustomHashMap(int capacity) {
        buckets = new LinkedList[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /*
     * Add a method to add an entry to the HashMap preventing collision, retrieve correct value based on a key


     */

    public void put(K key, V value) {

        int index = getIndexForKey(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : buckets[index]) {
            if ((key == null && entry.key == null) || (key != null && key.equals(entry.key))) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry(key, value));
        size++;

        if ((double) size / buckets.length > LOAD_FACTOR) {
            resizeHashMap();
        }
    }

    public boolean remove(K key) {
        int index = getIndexForKey(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    buckets[index].remove(entry);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    private void resizeHashMap() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;

        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }

    public V retrieve(K key) {
        int index = getIndexForKey(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (key != null && entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }
}
