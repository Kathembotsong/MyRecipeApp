package com.example.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recipeapp.databinding.ActivityRecipeDetailsBinding

class RecipeDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeDetailsBinding
    private lateinit var recipeViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeDetailsBinding.inflate(layoutInflater)
        // Initialize ViewModel
        recipeViewModel = RecipeViewModel(application)

        // Example: Get recipe details based on ID from Intent
        val recipeId = intent.getLongExtra("recipeId", 0)
        val recipe = recipeViewModel.getRecipeById(recipeId)

        // Example: Update UI with recipe details
        binding.txtTitle.text = recipe.title
        binding.txtMealType.text = recipe.mealType
        // Add other UI elements for displaying recipe details
    }
}
