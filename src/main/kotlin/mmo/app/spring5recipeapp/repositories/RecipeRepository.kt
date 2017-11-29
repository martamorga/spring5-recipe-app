package mmo.app.spring5recipeapp.repositories

import mmo.app.spring5recipeapp.domain.Recipe
import org.springframework.data.repository.CrudRepository

interface RecipeRepository : CrudRepository<Recipe, Long> {
}