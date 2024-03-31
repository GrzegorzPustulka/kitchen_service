package com.kitchen.controller;

import com.kitchen.model.Order;
import com.kitchen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService rabbitMQService) {
        this.orderService = rabbitMQService;
    }


    // TODO: dodac zwracanie wiecej niz jednego zamowienia, jesli kucharz poda odpowiedni parametr
    @GetMapping("/")
    public Order getNextOrderFromQueue() {
        return orderService.receiveOrderFromQueue();
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }
}
