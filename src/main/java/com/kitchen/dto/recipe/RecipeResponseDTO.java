package com.kitchen.dto.recipe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class RecipeResponseDTO {

    private UUID id;
    private String steps;
    private String name;


    public RecipeResponseDTO(UUID id, String steps, String name) {
        this.id = id;
        this.steps = steps;
        this.name = name;
    }
}
