package com.kitchen.repository;

import com.kitchen.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {


    @Query("select r from Recipe r where r.dish.id in :mealIds")
    List<Recipe> getRecipesByMealIds(List<UUID> mealIds);
}

