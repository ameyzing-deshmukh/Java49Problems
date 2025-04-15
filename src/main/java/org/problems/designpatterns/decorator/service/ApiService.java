package org.problems.designpatterns.decorator.service;

public interface ApiService {
    String fetchData(String key);

    String saveData(String key, String value);
}
