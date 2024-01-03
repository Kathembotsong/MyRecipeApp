package com.example.recipeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.databinding.ActivityExploreBinding
import com.example.recipeapp.databinding.ActivityRecipeDetailsBinding

class RecipeAdapter : ListAdapter<Recipe, RecipeAdapter.RecipeViewHolder>(RecipeDiffCallback()) {
   lateinit var binding: ActivityRecipeDetailsBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        binding = ActivityRecipeDetailsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = getItem(position)
        binding.txtTitle.text = recipe.title
        binding.txtMealType.text = recipe.mealType
        // ADD other information types
    }

    inner class RecipeViewHolder(binding: ActivityRecipeDetailsBinding)
        : RecyclerView.ViewHolder(binding.root) {
    }

    private class RecipeDiffCallback : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem == newItem
        }
    }
}
