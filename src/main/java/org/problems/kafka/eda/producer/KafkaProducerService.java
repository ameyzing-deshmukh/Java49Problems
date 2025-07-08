package org.problems.kafka.eda.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/*
 * we’ve created a KafkaProducerService class, responsible for sending messages (events) to the Kafka topic named "example_topic." We use the KafkaTemplate provided by Spring Kafka to publish messages.*/
@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic = "example_topic";

    @Autowired
    public KafkaProducerService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        System.out.println("Producer sending message: "+message);

        kafkaTemplate.send(topic, message);
    }
}
