package org.problems.corejava;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


public class ImmutableClassTest {

    private static final Logger logger = Logger.getLogger(ImmutableClassTest.class.getName());


    @Test
    public void testImmutableObjectCreation() {
        Map<Integer, String> immStringMap = Map.of(1, "MyName", 2, "YourName");
        Map<Integer, String> mutStringMap = new HashMap<>();
        mutStringMap.put(1, immStringMap.get(1));
        mutStringMap.put(2, immStringMap.get(2));

        ImmutableClass ic1 = new ImmutableClass("FirstName", 1, immStringMap);
        ImmutableClass ic2 = new ImmutableClass("FirstName", 1, mutStringMap);

        Set<ImmutableClass> objectSet = new HashSet();
        objectSet.add(ic1);
        objectSet.add(ic2);

        assertTrue(objectSet.contains(ic2));

        logger.info("Test class method run");
        assertEquals("FirstName", ic1.getName());
        assertEquals(1, ic1.getId());
        assertEquals(ic1, ic2);
        assertEquals(ic1.hashCode(), ic2.hashCode());
//        assertNotEquals(ic1, ic2, "Objects have different Maps.");

        mutStringMap.put(3, "YourName");
//        assertNotEquals(ic1, ic2, "Objects have different Maps.");
//        assertEquals(ic1, ic2);
//        assertEquals(ic1.hashcode(), ic2.hashcode());

        assertTrue(objectSet.contains(ic2));

    }

    @Test
    void getMapOfNames() {
        Map<Integer, String> immStringMap = Map.of(1, "MyName", 2, "YourName");

        ImmutableClass ic1 = new ImmutableClass("FirstName", 1, immStringMap);

        assertEquals(2, ic1.getMapOfNames().size());
    }
}
