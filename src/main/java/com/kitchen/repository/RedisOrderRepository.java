package com.kitchen.repository;

import com.kitchen.dto.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Repository
public class RedisOrderRepository {
    private static final String REDIS_KEY_PREFIX = "order:";

    private final RedisTemplate<String, Order> redisTemplate;

    @Autowired
    public RedisOrderRepository(RedisTemplate<String, Order> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveOrder(Order order) {
        redisTemplate.opsForValue().set(getRedisKey(order), order);
    }

    public Order getOrder(String orderId) {
        return redisTemplate.opsForValue().get(getRedisKeyPrefix() + orderId);
    }

    public List<Order> getAllOrders() {
        Set<String> keys = redisTemplate.keys(getRedisKeyPrefix() + "*");
        List<Order> orders = new ArrayList<>();
        if (keys != null) {
            for (String key : keys) {
                Order order = redisTemplate.opsForValue().get(key);
                orders.add(order);
            }
        }
        return orders;
    }

    public void deleteOrder(String orderId) {
        redisTemplate.delete(getRedisKeyPrefix() + orderId);
    }

    private String getRedisKey(Order order) {
        return getRedisKeyPrefix() + order.getId().toString();
    }

    private String getRedisKeyPrefix() {
        return REDIS_KEY_PREFIX;
    }

}
