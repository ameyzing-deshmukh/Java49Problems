package org.problems.kafka.eda2.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import static org.problems.kafka.eda2.constant.EDA2Constants.*;


@Service
public class EDA2ConsumerService {

    @KafkaListener(topics={EDA_2_TOPIC, EDA_2_SECOND_TOPIC}, groupId = EDA_2_GROUP)
    public void readMessage(String message){
        System.out.println(MESSAGE_RECEIVED_BY_CONSUMER_MESSAGE_IS +message);
    }
}
