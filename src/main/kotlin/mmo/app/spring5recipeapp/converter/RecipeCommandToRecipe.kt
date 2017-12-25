package mmo.app.spring5recipeapp.converter

import mmo.app.spring5recipeapp.commands.RecipeCommand
import mmo.app.spring5recipeapp.domain.Recipe
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class RecipeCommandToRecipe(private val categoryConveter: CategoryCommandToCategory, private val ingredientConverter: IngredientCommandToIngredient,
                            private val notesConverter: NotesCommandToNotes) : Converter<RecipeCommand, Recipe> {

    @Synchronized
    override fun convert(source: RecipeCommand): Recipe {

        val recipe = Recipe()
        recipe.apply {
            id = source.id
            cookTime = source.cookTime
            prepTime = source.prepTime
            description = source.description
            difficulty = source.difficulty
            directions = source.directions
            servings = source.servings
            url = source.url
            notesConverter.convert(source.notes)
        }

        if (source.categories.size > 0) {
            source.categories
                    .forEach { category -> recipe.categories.apply { (categoryConveter.convert(category)) } }
        }

        if (source.ingredients.size > 0) {
            source.ingredients
                    .forEach { ingredient -> recipe.ingredients.apply { (ingredientConverter.convert(ingredient)) } }
        }

        return recipe
    }
}
