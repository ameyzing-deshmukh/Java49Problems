package org.problems.designpatterns.decorator.config;

import org.problems.designpatterns.decorator.decorators.SecurityDecorator;
import org.problems.designpatterns.decorator.service.ApiService;
import org.problems.designpatterns.decorator.service.ApiServiceImpl;
import org.problems.designpatterns.decorator.decorators.LoggingDecorator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public ApiService apiService() {
        return new SecurityDecorator(new LoggingDecorator(new ApiServiceImpl()));
    }
}
