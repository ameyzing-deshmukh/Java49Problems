package org.problems.designpatterns.decorator.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApiServiceImpl implements ApiService {

    private static final Map<String, String> dataMap = new HashMap<>();

    @Override
    public String fetchData(String key) {
        String result = dataMap.get(key);
        return "Concrete implementation. Returned data: " + result + " for key: " + key;
    }

    @Override
    public String saveData(String key, String value) {
        dataMap.put(key, value);
        return "Concrete implementation. Saved data for key: " + key + " with value: " + value;

    }
}
