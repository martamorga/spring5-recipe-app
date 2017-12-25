package mmo.app.spring5recipeapp.converter

import mmo.app.spring5recipeapp.commands.IngredientCommand
import mmo.app.spring5recipeapp.domain.Ingredient
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class IngredientCommandToIngredient(private val uomConverter: UnitOfMeasureCommandToUnitOfMeasure) : Converter<IngredientCommand, Ingredient> {

    override fun convert(source: IngredientCommand): Ingredient {

        val ingredient = Ingredient()
        ingredient.apply {
            id = source.id
            amount = source.amount
            description = source.description
            unitOfMeasure = uomConverter.convert(source.unitOfMeasure)
        }
        return ingredient
    }
}