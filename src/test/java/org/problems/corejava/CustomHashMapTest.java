package org.problems.corejava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomHashMapTest {

    @Test
    void getIndexForKey() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(5);
        map.put("A", 1);
        map.put("B", 3);
        map.put("B", 3);

        assertEquals(1, map.retrieve("A"));
        assertEquals(3, map.retrieve("B"));
        assertNull(map.retrieve("C"));
        assertEquals(2, map.getSize());
    }

    @Test
    void put() {
    }

    @Test
    void remove() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(5);
        map.put("A", 1);
        map.put("B", 3);
        map.put("C", 3);
        map.put("D", 5);
        map.put("E", null);

        map.remove("D");
        map.put("D", 5);

        assertEquals(1, map.retrieve("A"));
        assertEquals(3, map.retrieve("B"));
        assertEquals(3, map.retrieve("C"));
        assertEquals(5, map.getSize());
        assertFalse(map.remove("kk"));
    }

    @Test
    void retrieve() {
    }
}