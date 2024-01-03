package com.example.recipeapp

import androidx.lifecycle.LiveData

class RecipeRepository(private val recipeDao: RecipeDao) {
    val allRecipes: LiveData<List<Recipe>> = recipeDao.getAllRecipes()

    suspend fun insert(recipe: Recipe) {
        recipeDao.insertRecipe(recipe)
    }

    fun getRecipeById(recipeId: Long): Recipe {
        return recipeDao.getRecipeById(recipeId)
    }
}
