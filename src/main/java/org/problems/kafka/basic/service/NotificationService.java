package org.problems.kafka.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.problems.kafka.basic.model.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    @KafkaListener(groupId = "notification-group", topics = "order-events", containerFactory = "notificationKafkaListenerContainerFactory")
    public void handleOrder(OrderEvent event) {
        log.info("Notification is issued for order id: {}", event.getOrderId());
    }
}
