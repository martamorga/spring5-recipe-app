package mmo.app.spring5recipeapp.commands

import java.math.BigDecimal

class IngredientCommand {
    val id: Long = 0
    val description: String = ""
    val amount: BigDecimal = BigDecimal.ZERO
    val unitOfMeasure: UnitOfMeasureCommand = UnitOfMeasureCommand()

}