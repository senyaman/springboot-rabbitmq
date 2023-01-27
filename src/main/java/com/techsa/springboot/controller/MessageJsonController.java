package com.techsa.springboot.controller;

import com.techsa.springboot.dto.User;
import com.techsa.springboot.publisher.RabbitMQJsonProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class MessageJsonController {

    private RabbitMQJsonProducer producer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        producer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ");
    }


}
