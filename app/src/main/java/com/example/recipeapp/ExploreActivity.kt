package com.example.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeapp.databinding.ActivityExploreBinding

class ExploreActivity : AppCompatActivity() {

    private lateinit var recipeViewModel: RecipeViewModel
    private lateinit var adapter: RecipeAdapter // Create a RecyclerView Adapter
    private lateinit var binding : ActivityExploreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExploreBinding.inflate(layoutInflater)

        // Initialize ViewModel
        recipeViewModel = RecipeViewModel(application)

        // Initialize RecyclerView Adapter
        adapter = RecipeAdapter()

        // Setup RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Observe changes in the ViewModel's LiveData
        recipeViewModel.allRecipes.observe(this, { recipes ->
            // Update the adapter with the new list of recipes
            adapter.submitList(recipes)
        })
    }
}
