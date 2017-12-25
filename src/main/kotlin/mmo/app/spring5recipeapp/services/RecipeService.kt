package mmo.app.spring5recipeapp.services

import mmo.app.spring5recipeapp.commands.RecipeCommand
import mmo.app.spring5recipeapp.domain.Recipe

interface RecipeService {

    fun getRecipes(): Set<Recipe>

    fun findById(id: Long): Recipe

    fun saveRecipeCommand(command: RecipeCommand): RecipeCommand
}