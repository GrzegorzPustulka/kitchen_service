package com.kitchen.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderDTO {
    private UUID id;
    private String orderDateTime;
    private String preparationTime = LocalDateTime.now().toString();;
    private String notes;
    private List<OrderItem> meals;

    @Getter
    @Setter
    private static class OrderItem {
        private String meal;
        private Integer count;
    }
}
