package com.kitchen.repository;

import com.kitchen.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {


    @Query("select r, d from Recipe r inner join Dish d on d.id = r.dish.id where r.dish.id = :mealId")
    Recipe getRecipeByMealId(UUID mealId);
}

