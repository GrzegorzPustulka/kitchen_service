package com.kitchen.service;

import com.kitchen.dto.RecipeDTO;
import com.kitchen.model.Recipe;
import com.kitchen.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDTO> getRecipesByMealIds(List<String> MealIds) {
        List<Recipe> recipes = this.recipeRepository.getRecipesByMealIds(MealIds);
        return recipes.stream()
                .map(recipe -> new RecipeDTO(recipe.getId(), recipe.getSteps()))
                .collect(Collectors.toList());
    }
}
