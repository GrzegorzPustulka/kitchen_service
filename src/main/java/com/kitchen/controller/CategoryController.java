package com.kitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

//    private final CategoryService categoryService;
//
//    @Autowired
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    @GetMapping("/")
//    public List<CategoryResponseDTO> getAllCategories() {
//        return categoryService.getAllCategories();
//    }
//
//
//    @GetMapping("/{categoryId}")
//    public CategoryResponseDTO getCategoryById(@PathVariable UUID categoryId) {
//        return categoryService.getCategoryById(categoryId);
//    }
//
//    @GetMapping("{categoryId}/recipes")
//    public List<RecipeResponseDTO> getRecipesByCategoryId(@PathVariable UUID categoryId) {
//        return categoryService.getRecipesByCategoryId(categoryId);
//    }
//
//    @PatchMapping("/{categoryId}")
//    public CategoryResponseDTO updateCategory(@PathVariable UUID categoryId, @RequestBody CategoryUpdateDTO category) {
//        return categoryService.updateCategory(categoryId, category);
//    }
//
//    @PostMapping("/")
//    public CategoryResponseDTO createCategory(@RequestBody CategoryCreationDTO category) {
//        return categoryService.createCategory(category);
//    }
//
//    @DeleteMapping("/{categoryId}")
//    public void deleteCategory(@PathVariable UUID categoryId) {
//        categoryService.deleteCategory(categoryId);
//    }

}
