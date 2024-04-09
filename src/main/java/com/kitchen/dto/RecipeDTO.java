package com.kitchen.dto;

import com.kitchen.model.Dish;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDTO {

    private UUID id;
    private String steps;
    private String name;


    public RecipeDTO(UUID id, String steps, String name) {
        this.id = id;
        this.steps = steps;
        this.name = name;
    }
}
