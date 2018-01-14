package mmo.app.spring5recipeapp.services

import mmo.app.spring5recipeapp.domain.Ingredient
import mmo.app.spring5recipeapp.domain.Recipe
import mmo.app.spring5recipeapp.domain.UnitOfMeasure
import mmo.app.spring5recipeapp.repositories.IngredientRepository
import mmo.app.spring5recipeapp.repositories.RecipeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IngredientServiceImpl : IngredientService {

    @Autowired
    lateinit var recipeRepository: RecipeRepository

    @Autowired
    lateinit var ingredientRepository: IngredientRepository

    override fun findByRecipeIdAndIngredientId(recipeId: Long, ingredientId: Long): Ingredient {

        val recipe = recipeRepository.findOne(recipeId) ?: throw Exception("Nie znaleziono przepisu o podanym ID")

        val ingred = recipe.ingredients.first { it.id == ingredientId }

        return ingred
    }

    override fun getIngredients(): Set<Ingredient> = ingredientRepository.findAll().toHashSet()


    override fun findOneIngredient(ingredientId: Long): Ingredient {
        return ingredientRepository.findOne(ingredientId)
    }

    override fun deleteById(ingredientId: Long) {
        ingredientRepository.delete(ingredientId)
    }


    override fun getRecipeId(ingredientId: Long): Recipe? {
        val ingredient = ingredientRepository.findOne(ingredientId)
        return ingredient.recipe
    }


    override fun getUnitOfMeasure(ingredientId: Long): UnitOfMeasure? {
        val ingredient = ingredientRepository.findOne(ingredientId)
        return ingredient.unitOfMeasure
    }

    override fun save(ingredient: Ingredient): Ingredient {

        val recipeNew = if (ingredient.recipe?.description.isNullOrEmpty()) {
            getRecipeId(ingredient.id!!)
        } else {
            ingredient.recipe
        }

        val unitOfMeasureNew = if (ingredient.unitOfMeasure?.description.isNullOrEmpty()) {
            getUnitOfMeasure(ingredient.id!!)
        } else {
            ingredient.unitOfMeasure
        }


        val newIngredient = ingredient.apply {
            id = ingredient.id
            description = ingredient.description
            amount = ingredient.amount
            recipe = recipeNew
            unitOfMeasure = unitOfMeasureNew
        }
        return ingredientRepository.save(newIngredient)
    }


}