package org.problems.designpatterns.decorator.decorators;

import org.problems.designpatterns.decorator.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SecurityDecorator implements ApiService {

    Logger logger = LoggerFactory.getLogger(SecurityDecorator.class);
    private final ApiService apiService;

    List<String> userList = List.of("Amey", "Vijay");

    public SecurityDecorator(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public String fetchData(String key) {
        logger.info("Authenticating key before fetching data: {}", key);
        if (authenticate(key)) {
            return apiService.fetchData(key);
        } else {
            return "key is not authenticated";
        }
    }

    @Override
    public String saveData(String key, String value) {
        logger.info("Authenticating key before saving data: {}", key);
        if (authenticate(key)) {
            return apiService.saveData(key, value);
        } else {
            return "key is not authenticated";
        }
    }

    private boolean authenticate(String key) {
        return userList.contains(key);
    }
}
