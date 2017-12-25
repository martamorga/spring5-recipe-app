package mmo.app.spring5recipeapp.converter

import mmo.app.spring5recipeapp.commands.UnitOfMeasureCommand
import mmo.app.spring5recipeapp.domain.UnitOfMeasure
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class UnitOfMeasureToUnitOfMeasureCommand : Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    override fun convert(unitOfMeasure: UnitOfMeasure): UnitOfMeasureCommand {

        val uomc = UnitOfMeasureCommand()
        uomc.apply {
            unitOfMeasure.id
            unitOfMeasure.description
        }
        return uomc

    }
}