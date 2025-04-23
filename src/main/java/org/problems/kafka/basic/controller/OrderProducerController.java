package org.problems.kafka.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.problems.kafka.basic.model.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderProducerController {

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderEvent orderEvent) {
        orderEvent.setStatus("CREATED");
        kafkaTemplate.send("order-events", orderEvent.getOrderId(), orderEvent);
        log.info("In OrderProducerController. Order created with order id {}", orderEvent.getOrderId());
        return ResponseEntity.ok("Order Created and Event Published");
    }
}
