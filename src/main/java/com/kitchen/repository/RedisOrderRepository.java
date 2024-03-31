package com.kitchen.repository;

import com.kitchen.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RedisOrderRepository {
    private static final String REDIS_KEY_PREFIX = "order:";

    private final RedisTemplate<String, Order> redisTemplate;

    @Autowired
    public RedisOrderRepository(RedisTemplate<String, Order> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveOrder(Order order) {
        redisTemplate.opsForValue().set(REDIS_KEY_PREFIX + order.getId(), order);
    }

    public Order getOrder(String orderId) {
        return redisTemplate.opsForValue().get(REDIS_KEY_PREFIX + orderId);
    }

}
