package com.kitchen.controller;

import com.kitchen.dto.Order;
import com.kitchen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
    }
}
