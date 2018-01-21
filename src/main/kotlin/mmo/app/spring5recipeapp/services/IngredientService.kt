package mmo.app.spring5recipeapp.services

import mmo.app.spring5recipeapp.domain.Ingredient
import mmo.app.spring5recipeapp.domain.Recipe
import mmo.app.spring5recipeapp.domain.UnitOfMeasure

interface IngredientService {

    fun findByRecipeIdAndIngredientId(recipeId: Long, ingredientId: Long): Ingredient

    fun findOneIngredient(ingredientId: Long): Ingredient

    fun deleteById(ingredientId: Long)

    fun save(ingredient: Ingredient, uom: UnitOfMeasure): Ingredient

    fun create(ingredient: Ingredient): Ingredient

    fun getIngredients(): Set<Ingredient>

    fun getRecipeId(ingredientId: Long): Recipe?

    fun getUnitOfMeasure(ingredientId: Long): UnitOfMeasure?

}