package com.kitchen.controller;

import com.kitchen.dto.recipe.RecipeResponseDTO;
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
    public RecipeResponseDTO getRecipeByMealId(@PathVariable UUID mealId) {
        return recipeService.getRecipeByMealId(mealId);
    }

    @GetMapping("/")
    public List<RecipeResponseDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

//    TODO: I need spring security to implement this method
//    @PostMapping("/")
//    public RecipeResponseDTO createRecipe(@RequestBody RecipeCreationDTO recipe) {
//        return recipeService.createRecipe(recipe);
//    }
//    TODO: I need spring security to implement this method
//    @PatchMapping("/{mealId}")
//    public RecipeResponseDTO updateRecipe(@PathVariable UUID mealId, @RequestBody RecipeUpdateDTO recipe) {
//        return recipeService.updateRecipe(mealId, recipe);
//    }
//    TODO: I need spring security to implement this method
//    @DeleteMapping("/{mealId}")
//    public void deleteRecipe(@PathVariable UUID mealId) {
//        recipeService.deleteRecipe(mealId);
//    }
}
