package mmo.app.spring5recipeapp.converter

import mmo.app.spring5recipeapp.commands.UnitOfMeasureCommand
import mmo.app.spring5recipeapp.domain.UnitOfMeasure
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class UnitOfMeasureCommandToUnitOfMeasure : Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    override fun convert(source: UnitOfMeasureCommand): UnitOfMeasure {
        val uom = UnitOfMeasure()
        uom.apply { id = source.id
        description = source.description}
        return uom
    }
}