package org.problems.kafka.eda.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleTopic {
    /*
     * we use a @Configuration class to define the Kafka topic "example_topic" with one partition and one replication factor. Replication factor ensures fault tolerance by replicating data across multiple brokers.*/

    @Bean
    public NewTopic exampleTopic1() {
        return new NewTopic("example_topic", 1, (short) 1);
    }
}
