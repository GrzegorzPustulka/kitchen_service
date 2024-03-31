package com.kitchen.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
class OrderItem {
    private String meal;
    private Integer count;
}

@Getter
@Setter
public class Order {
    private UUID id;
    private List<OrderItem> meals;
}
