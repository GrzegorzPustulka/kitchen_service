package com.kitchen.controller;

import com.kitchen.dto.RecipeDTO;
import com.kitchen.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{mealId}")
    public RecipeDTO getRecipeByMealId(@PathVariable UUID mealId) {
        return recipeService.getRecipeByMealId(mealId);
    }
}
