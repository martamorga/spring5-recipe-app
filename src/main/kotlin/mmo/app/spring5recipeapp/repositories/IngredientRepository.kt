package mmo.app.spring5recipeapp.repositories

import mmo.app.spring5recipeapp.domain.Ingredient
import org.springframework.data.repository.CrudRepository

interface IngredientRepository: CrudRepository<Ingredient, Long> {

}