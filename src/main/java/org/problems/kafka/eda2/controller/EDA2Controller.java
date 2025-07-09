package org.problems.kafka.eda2.controller;

import org.problems.kafka.eda2.producer.EDA2ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.problems.kafka.eda2.constant.EDA2Constants.*;

@RestController
@RequestMapping("/eda2")
public class EDA2Controller {

    @Autowired
    private EDA2ProducerService eda2Producer;
    @GetMapping("/message/{message}")
    public ResponseEntity sendMessageToTopic(@PathVariable String message){
        eda2Producer.send(message);
        System.out.println(STARS + MESSAGE_SENT_SUCCESSFULLY_TO_EDA_2_TOPIC +message);
        return ResponseEntity.ok(MESSAGE_SENT_SUCCESSFULLY_TO_EDA_2_TOPIC+message);
    }
}
