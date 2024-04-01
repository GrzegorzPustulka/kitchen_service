package com.kitchen.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderDTO {
    private UUID id;
    private List<OrderItem> meals;

    @Getter
    @Setter
    private static class OrderItem {
        private String meal;
        private Integer count;
    }
}
