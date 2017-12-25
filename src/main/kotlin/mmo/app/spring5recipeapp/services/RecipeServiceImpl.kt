package mmo.app.spring5recipeapp.services

import jdk.nashorn.internal.runtime.regexp.joni.Config.log
import mmo.app.spring5recipeapp.commands.RecipeCommand
import mmo.app.spring5recipeapp.converter.RecipeCommandToRecipe
import mmo.app.spring5recipeapp.converter.RecipeToRecipeCommand
import mmo.app.spring5recipeapp.domain.Recipe
import mmo.app.spring5recipeapp.repositories.RecipeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl : RecipeService {
    @Autowired
    lateinit var recipeRepository: RecipeRepository
    lateinit var recipeCommandToRecipe: RecipeCommandToRecipe
    lateinit var recipeToRecipeCommand: RecipeToRecipeCommand


    override fun getRecipes(): Set<Recipe> = recipeRepository.findAll().toHashSet()


    override fun findById(id: Long): Recipe {

        return recipeRepository.findOne(id) ?: throw Exception("Nie znaleziono przepisu o danym ID")

    }

    override fun saveRecipeCommand(command: RecipeCommand): RecipeCommand {
        val detachedRecipe = recipeCommandToRecipe.convert(command)

        val savedRecipe = recipeRepository.save(detachedRecipe)
        return recipeToRecipeCommand.convert(savedRecipe)
    }
}