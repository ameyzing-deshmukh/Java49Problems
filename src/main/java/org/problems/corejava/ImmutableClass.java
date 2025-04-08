package org.problems.corejava;

import java.util.Map;
import java.util.Objects;

public final class ImmutableClass {

    private final int id;
    private final String name;
    private final Map<Integer, String> mapOfNames;

    public ImmutableClass(String name, int id, Map<Integer, String> providedMap) {
        this.name = name;
        this.id = id;
        this.mapOfNames = Map.copyOf(providedMap);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Map<Integer, String> getMapOfNames() {
        return mapOfNames;
    }

    public boolean equals(Object o){
        if(this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableClass ic = (ImmutableClass) o;
        return this.id == ic.id && Objects.equals(name, ic.name) && Objects.equals(mapOfNames, ic.mapOfNames);
    }

    public int hashCode(){
        return Objects.hash(id, name, mapOfNames);
    }



}
