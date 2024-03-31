package com.kitchen.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitchen.config.RabbitMQConfig;
import com.kitchen.model.Order;
import com.kitchen.repository.RedisOrderRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final RabbitMQConfig rabbitMQConfig;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    private final RedisOrderRepository redisOrderRepository;


    @Autowired
    public OrderService(RabbitMQConfig rabbitMQConfig, RabbitTemplate rabbitTemplate, RedisOrderRepository redisOrderRepository, ObjectMapper objectMapper) {
        this.rabbitMQConfig = rabbitMQConfig;
        this.rabbitTemplate = rabbitTemplate;
        this.redisOrderRepository = redisOrderRepository;
        this.objectMapper = objectMapper;
    }


    public Order getOrder(String orderId) {
        return redisOrderRepository.getOrder(orderId);
    }

    public void saveOrder(Order order) {
        redisOrderRepository.saveOrder(order);
    }

    public Order receiveOrderFromQueue() {
        Message message = rabbitTemplate.receive(rabbitMQConfig.getQueueName());

        if (message != null ) {
            try {
                String messageBody = new String(message.getBody(), StandardCharsets.UTF_8);
                saveOrder(objectMapper.readValue(messageBody, Order.class));
                return objectMapper.readValue(messageBody, Order.class);
            } catch (IOException e) {
                logger.error("Error while parsing JSON message", e);
            }
        }

        return null;
    }
}
