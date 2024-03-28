package com.kitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private Order order;

    @Autowired
    public OrderController(Order order) {
        this.order = order;
    }

    @GetMapping("/order")
    public String getOrder() {
        return this.order.receiveOrder();
    }

}
