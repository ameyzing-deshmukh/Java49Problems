package org.problems.kafka.eda.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/*The KafkaConsumerService class listens to the "example_topic" and belongs to the consumer group "example_group." Whenever a message is published to the topic, the receiveMessage method will be invoked to process the incoming event.*/

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "example_topic", groupId = "example_group")
    public void receiveMessage(String message) {
        System.out.println("Received message is: " + message);
    }
}
