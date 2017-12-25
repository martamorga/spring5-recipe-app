package mmo.app.spring5recipeapp.converter

import groovy.transform.Synchronized
import mmo.app.spring5recipeapp.commands.RecipeCommand
import mmo.app.spring5recipeapp.domain.Category
import mmo.app.spring5recipeapp.domain.Recipe
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class RecipeToRecipeCommand(private val categoryConveter: CategoryToCategoryCommand,
                            private val ingredientConverter: IngredientToIngredientCommand,
                            private val notesConverter: NotesToNotesCommand) : Converter<Recipe, RecipeCommand> {

    @Synchronized
    override fun convert(source: Recipe): RecipeCommand {

        val command = RecipeCommand()
        command.apply {
            source.id
            source.cookTime
            source.prepTime
            source.description
            source.difficulty
            source.directions
            source.servings
            source.source
            source.url
            notesConverter.convert(source.notes)
        }

        if (source.categories.isNotEmpty()) {
            source.categories
                    .forEach { category: Category -> command.categories.add(categoryConveter.convert(category)) }
        }

        if (source.ingredients.isNotEmpty()) {
            source.ingredients
                    .forEach { ingredient -> command.ingredients.add(ingredientConverter.convert(ingredient)) }
        }

        return command
    }
}
