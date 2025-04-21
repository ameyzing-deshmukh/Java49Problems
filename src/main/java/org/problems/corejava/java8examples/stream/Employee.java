package org.problems.corejava.java8examples.stream;

public class Employee {
    String name;
    String lName;
    int age;

    public Employee(String name, String lName, int age) {
        this.name = name;
        this.lName = lName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                '}';
    }
}
