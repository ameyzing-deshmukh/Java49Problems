package org.problems.kafka.ordermanagement.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.problems.kafka.ordermanagement.event.OrderEvent;
import org.problems.kafka.ordermanagement.producer.OrderProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.problems.kafka.ordermanagement.util.Constants;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderEventController {

@Autowired
private OrderProducerService orderProducerService;

    @PostMapping("/create")
    public ResponseEntity createOrder(@RequestBody OrderEvent orderEvent){
        String orderId = "";
        orderProducerService.passOrder(orderEvent);
        log.info("Order is getting created. ");
        return ResponseEntity.ok(Constants.ORDER_PASSED_WITH_ORDER_ID +orderId);
    }

}
