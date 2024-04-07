package com.kitchen.controller;

import com.kitchen.dto.OrderDTO;
import com.kitchen.enums.OrderStatus;
import com.kitchen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService rabbitMQService) {
        this.orderService = rabbitMQService;
    }


    // TODO: dodac obsluge bledow, np. jesli zamowienie nie istnieje.
    @GetMapping("/")
    public Mono<OrderDTO> getNextOrderFromQueue() {
        return orderService.receiveOrderFromQueue();
    }

    @GetMapping("/{orderId}")
    public OrderDTO getOrder(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping("/all")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/{orderId}")
    public Mono<Void> deleteOrder(@PathVariable String orderId, @RequestParam("status") OrderStatus status) {
        return orderService.deleteOrder(orderId, status);
    }
}
