package com.kitchen.service;

import com.kitchen.dto.Recipe.RecipeResponseDTO;
import com.kitchen.model.Recipe;
import com.kitchen.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public RecipeResponseDTO getRecipeByMealId(UUID mealId) {
        Recipe recipe = this.recipeRepository.getRecipeByMealId(mealId);
        return new RecipeResponseDTO(recipe.getId(), recipe.getSteps(), recipe.getDish().getName());
    }

    public List<RecipeResponseDTO> getAllRecipes() {
        return this.recipeRepository.findAll().stream()
                .map(recipe -> new RecipeResponseDTO(recipe.getId(), recipe.getSteps(), recipe.getDish().getName()))
                .collect(Collectors.toList());
    }
}
