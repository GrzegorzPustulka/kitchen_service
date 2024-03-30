package com.kitchen.controller;

import com.kitchen.model.Meal;
import com.kitchen.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    private final RabbitMQService rabbitMQService;

    @Autowired
    public RabbitMQController(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }


    @GetMapping("/retrieve-new-order")
    public Meal consumeMessage() {
        return rabbitMQService.consumeMessage();
    }
}
