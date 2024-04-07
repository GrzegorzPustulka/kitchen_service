package com.kitchen.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitchen.config.RabbitMQConfig;
import com.kitchen.dto.OrderDTO;
import com.kitchen.dto.OrderStatusRequest;
import com.kitchen.enums.OrderStatus;
import com.kitchen.repository.RedisOrderRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Collections.reverse;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final RabbitMQConfig rabbitMQConfig;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    private final RedisOrderRepository redisOrderRepository;

    private final OrderStatusService orderStatusService;


    @Autowired
    public OrderService(RabbitMQConfig rabbitMQConfig, RabbitTemplate rabbitTemplate, RedisOrderRepository redisOrderRepository, OrderStatusService orderStatusService, ObjectMapper objectMapper) {
        this.rabbitMQConfig = rabbitMQConfig;
        this.rabbitTemplate = rabbitTemplate;
        this.orderStatusService = orderStatusService;
        this.redisOrderRepository = redisOrderRepository;
        this.objectMapper = objectMapper;
    }


    public OrderDTO getOrder(String orderId) {
        return redisOrderRepository.getOrder(orderId);
    }

    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orderDTOList = redisOrderRepository.getAllOrders();
        return orderDTOList.stream()
                .sorted((o1, o2) -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                    LocalDateTime time1 = LocalDateTime.parse(o1.getPreparationTime(), formatter);
                    LocalDateTime time2 = LocalDateTime.parse(o2.getPreparationTime(), formatter);
                    return time1.compareTo(time2);
                })
                .collect(Collectors.toList());
    }

    private Mono<Void> saveOrder(OrderDTO orderDTO) {
        OrderStatusRequest orderStatusRequest = new OrderStatusRequest(orderDTO.getId(), OrderStatus.PREPARING);
        return orderStatusService.sendNewOrderStatus(orderStatusRequest)
                .then(Mono.fromRunnable(() -> redisOrderRepository.saveOrder(orderDTO)));
    }

    public Mono<Void> deleteOrder(String orderId, OrderStatus status) {
        OrderDTO orderDTO = getOrder(orderId);
        if (orderDTO == null) {
            return Mono.error(new RuntimeException("Order not found"));
        }
        redisOrderRepository.deleteOrder(orderId);
        OrderStatusRequest statusRequest = new OrderStatusRequest(UUID.fromString(orderId), status);
        return orderStatusService.sendNewOrderStatus(statusRequest);
    }

    public Mono<OrderDTO> receiveOrderFromQueue() {
        return Mono.fromCallable(() -> rabbitTemplate.receive(rabbitMQConfig.getQueueName()))
                .flatMap(message -> {
                    if (message == null) {
                        return Mono.empty(); // lub Mono.error(new CustomException("Message is null"));
                    }
                    try {
                        String messageBody = new String(message.getBody(), StandardCharsets.UTF_8);
                        OrderDTO orderDTO = objectMapper.readValue(messageBody, OrderDTO.class);
                        return saveOrder(orderDTO).thenReturn(orderDTO);
                    } catch (IOException e) {
                        logger.error("Error while parsing JSON message", e);
                        return Mono.error(e);
                    }
                });
    }
}
