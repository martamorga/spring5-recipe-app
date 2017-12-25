package mmo.app.spring5recipeapp.converter

import mmo.app.spring5recipeapp.commands.IngredientCommand
import mmo.app.spring5recipeapp.domain.Ingredient
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class IngredientToIngredientCommand(private val uomConverter: UnitOfMeasureToUnitOfMeasureCommand) : Converter<Ingredient, IngredientCommand> {

    @Synchronized
    override fun convert(ingredient: Ingredient): IngredientCommand {

        val ingredientCommand = IngredientCommand()
        ingredientCommand.apply { ingredient.id
            ingredient.amount
            ingredient.description
            ingredient.unitOfMeasure
        }
        return ingredientCommand
    }
}