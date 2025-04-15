package org.problems.designpatterns.decorator.decorators;

import org.problems.designpatterns.decorator.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggingDecorator implements ApiService {

    private static final Logger logger = LoggerFactory.getLogger(LoggingDecorator.class);
    protected ApiService apiService;

    public LoggingDecorator(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public String fetchData(String key) {
        logger.info("Calling fetchData() for key: {}", key);
        String result = apiService.fetchData(key);
        logger.info("Result '{}' for key {}", result, key);
        return result;
    }

    @Override
    public String saveData(String key, String value) {
        logger.info("Calling saveData() for key {} with value {} ", key, value);
        String result = apiService.saveData(key, value);
        logger.info("Data saved for key: {} with value: {} and returned following result: {}", key, value, result);
        return result;
    }
}
