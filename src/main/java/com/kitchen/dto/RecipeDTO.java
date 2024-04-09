package com.kitchen.dto;

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

    public RecipeDTO(UUID id, String steps) {
        this.id = id;
        this.steps = steps;
    }
}
