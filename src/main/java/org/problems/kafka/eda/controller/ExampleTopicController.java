package org.problems.kafka.eda.controller;

import org.problems.kafka.eda.producer.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleTopicController {

    @Autowired
    private KafkaProducerService producerService;

    @GetMapping("/trigger_producer/{message}")
    public ResponseEntity triggerExampleProducer(@PathVariable String message) {
        System.out.println("Message received is: " + message);

        producerService.sendMessage(message);
        return ResponseEntity.ok("message published successfully.");
    }
}
