package com.kitchen.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitchen.config.RabbitMQConfig;
import com.kitchen.model.Meal;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class RabbitMQService {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQService.class);

    private final RabbitMQConfig rabbitMQConfig;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;


    @Autowired
    public RabbitMQService(RabbitMQConfig rabbitMQConfig, RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitMQConfig = rabbitMQConfig;
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public Meal consumeMessage() {
        Message message = rabbitTemplate.receive(rabbitMQConfig.getQueueName());

        if (message != null && message.getBody() != null) {
            try {
                String messageBody = new String(message.getBody(), StandardCharsets.UTF_8);
                return objectMapper.readValue(messageBody, Meal.class);
            } catch (IOException e) {
                logger.error("Error while parsing JSON message", e);
            }
        }

        return null;
    }
}
