package mmo.app.spring5recipeapp.converter

import mmo.app.spring5recipeapp.commands.CategoryCommand
import mmo.app.spring5recipeapp.domain.Category
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CategoryToCategoryCommand : Converter<Category, CategoryCommand> {

    @Synchronized
    override fun convert(source: Category): CategoryCommand {

        val categoryCommand = CategoryCommand()

        categoryCommand.apply {
            source.id
            source.description
        }

        return categoryCommand
    }
}