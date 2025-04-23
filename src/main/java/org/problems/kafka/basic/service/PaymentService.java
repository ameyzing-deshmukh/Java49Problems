package org.problems.kafka.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.problems.kafka.basic.model.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    @KafkaListener(groupId = "payment-group", topics = "order-events", containerFactory = "kafkaListenerContainerFactory")
    public void handleOrder(OrderEvent event) {
        log.info("Processing payment for Order: {}", event.getOrderId());
        log.info("Processed payment for Order: {}", event.getOrderId());
    }
}
