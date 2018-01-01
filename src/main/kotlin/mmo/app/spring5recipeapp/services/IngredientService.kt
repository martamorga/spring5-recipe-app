package mmo.app.spring5recipeapp.services

import mmo.app.spring5recipeapp.domain.Ingredient
import mmo.app.spring5recipeapp.domain.Recipe

interface IngredientService {

    fun findByRecipeIdAndIngredientId(recipeId: Long, ingredientId: Long): Ingredient


}