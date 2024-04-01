package com.kitchen.repository;

import com.kitchen.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class RedisOrderRepository {
    private static final String REDIS_KEY_PREFIX = "order:";

    private final RedisTemplate<String, OrderDTO> redisTemplate;

    @Autowired
    public RedisOrderRepository(RedisTemplate<String, OrderDTO> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveOrder(OrderDTO orderDTO) {
        redisTemplate.opsForValue().set(getRedisKey(orderDTO), orderDTO);
    }

    public OrderDTO getOrder(String orderId) {
        return redisTemplate.opsForValue().get(getRedisKeyPrefix() + orderId);
    }

    public List<OrderDTO> getAllOrders() {
        Set<String> keys = redisTemplate.keys(getRedisKeyPrefix() + "*");
        List<OrderDTO> orderDTOS = new ArrayList<>();
        if (keys != null) {
            for (String key : keys) {
                OrderDTO orderDTO = redisTemplate.opsForValue().get(key);
                orderDTOS.add(orderDTO);
            }
        }
        return orderDTOS;
    }

    public void deleteOrder(String orderId) {
        redisTemplate.delete(getRedisKeyPrefix() + orderId);
    }

    private String getRedisKey(OrderDTO orderDTO) {
        return getRedisKeyPrefix() + orderDTO.getId().toString();
    }

    private String getRedisKeyPrefix() {
        return REDIS_KEY_PREFIX;
    }

}
