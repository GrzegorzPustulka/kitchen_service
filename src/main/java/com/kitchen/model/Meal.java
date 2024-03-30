package com.kitchen.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
class MealItem {
    private String meal;
    private Integer count;
}

@Getter
@Setter
public class Meal {
    private String id;
    private List<MealItem> meals;
}
