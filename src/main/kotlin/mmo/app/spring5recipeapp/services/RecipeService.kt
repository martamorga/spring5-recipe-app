package mmo.app.spring5recipeapp.services

import mmo.app.spring5recipeapp.domain.Recipe

interface RecipeService {

    fun getRecipes(): Set<Recipe>

    fun findById(id: Long): Recipe

    fun create(recipe: Recipe): Recipe

    fun save(recipe: Recipe): Recipe

    fun edit(recipe: Recipe): Recipe

    fun deleteById(id: Long)

}