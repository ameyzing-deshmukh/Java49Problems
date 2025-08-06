package org.problems.kafka.ordermanagement.producer;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Order;
import org.problems.kafka.ordermanagement.event.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderProducerService {

    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderProducerService(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        log.info("Template is created for Order Event.");
        this.kafkaTemplate = kafkaTemplate;
    }

    public void passOrder(OrderEvent orderEvent) {
        log.info("Order event is passed to Order Topic");
        kafkaTemplate.send("order_topic", orderEvent);
    }
}
