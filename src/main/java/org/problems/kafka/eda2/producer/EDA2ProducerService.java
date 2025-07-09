package org.problems.kafka.eda2.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static org.problems.kafka.eda2.constant.EDA2Constants.*;

@Service
public class EDA2ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public EDA2ProducerService(KafkaTemplate template){
        this.kafkaTemplate = template;
    }

    public void send(String message){
        kafkaTemplate.send(EDA_2_TOPIC, message);
        kafkaTemplate.send(EDA_2_SECOND_TOPIC, message+message);

    }
}
