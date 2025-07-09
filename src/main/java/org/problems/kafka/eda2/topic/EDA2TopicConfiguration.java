package org.problems.kafka.eda2.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.problems.kafka.eda2.constant.EDA2Constants.*;

@Configuration
public class EDA2TopicConfiguration {

    @Bean
    public NewTopic eda2Topic(){
        System.out.println(TOPIC_IS_READY +EDA_2_TOPIC);
        return new NewTopic(EDA_2_TOPIC, 1, (short) 1);
    }

    @Bean
    public NewTopic eda2SecondTopic(){
        System.out.println(TOPIC_IS_READY+EDA_2_SECOND_TOPIC);
        return new NewTopic(EDA_2_SECOND_TOPIC, 1, (short) 1);
    }
}
