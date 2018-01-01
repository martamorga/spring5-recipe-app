package mmo.app.spring5recipeapp.services

import mmo.app.spring5recipeapp.domain.Ingredient
import mmo.app.spring5recipeapp.domain.Recipe
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

        val recipe = recipeRepository.findOne(recipeId)?: throw Exception("Nie znaleziono przepisu o podanym ID")

        val ingred = recipe.ingredients.first { it.id==ingredientId }

        return ingred
    }

}