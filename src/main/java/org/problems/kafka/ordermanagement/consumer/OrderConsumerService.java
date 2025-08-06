package org.problems.kafka.ordermanagement.consumer;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Order;
import org.problems.kafka.ordermanagement.event.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderConsumerService {

    @KafkaListener(topics = "order_topic", groupId = "order_group")
    public void consumeOrderTopic(OrderEvent orderEvent){
        log.info("Order event is consumed with Order Id."+orderEvent.getOrderNumber());
        log.info(orderEvent.toString());
    }
}
