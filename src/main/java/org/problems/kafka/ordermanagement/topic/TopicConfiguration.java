package org.problems.kafka.ordermanagement.topic;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class TopicConfiguration {

    @Bean
    public NewTopic orderEventTopic(){
        log.info("New topic for order event is created.");
        return new NewTopic("order_topic", 1, (short) 1);
    }
}
