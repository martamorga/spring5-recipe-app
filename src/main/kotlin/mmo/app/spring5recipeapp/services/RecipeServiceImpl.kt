package mmo.app.spring5recipeapp.services

import mmo.app.spring5recipeapp.domain.Recipe
import mmo.app.spring5recipeapp.repositories.RecipeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl : RecipeService {

    @Autowired
    lateinit var recipeRepository: RecipeRepository


    override fun getRecipes(): Set<Recipe> = recipeRepository.findAll().toHashSet()


    override fun findById(id: Long): Recipe =
            recipeRepository.findOne(id) ?: throw Exception("Nie znaleziono przepisu o danym ID")

    override fun create(recipe: Recipe): Recipe = recipeRepository.save(recipe)

    override fun save(recipe: Recipe): Recipe = recipeRepository.save(recipe)

    override fun edit(recipe: Recipe): Recipe = recipeRepository.save(recipe)

    override fun deleteById(id: Long) = recipeRepository.delete(id)


}