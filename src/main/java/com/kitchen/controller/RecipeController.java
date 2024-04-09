package com.kitchen.controller;

import com.kitchen.dto.RecipeDTO;
import com.kitchen.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public List<RecipeDTO> getRecipesByMealIds(@RequestParam List<String> MealIds) {
        return recipeService.getRecipesByMealIds(MealIds);
    }
}
