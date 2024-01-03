package com.example.recipeapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val mealType: String,
    val servingSize: Int,
    val difficultyLevel: String,
    val ingredients: String,
    val preparationSteps: String
)
