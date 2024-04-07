package com.kitchen.dto;

import java.util.UUID;

import com.kitchen.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatusRequest {
    private UUID Id;
    private OrderStatus orderStatus;

    public OrderStatusRequest(UUID Id, OrderStatus orderStatus) {
        this.Id = Id;
        this.orderStatus = orderStatus;
    }
}
