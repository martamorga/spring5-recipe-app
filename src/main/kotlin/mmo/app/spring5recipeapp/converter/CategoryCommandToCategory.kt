package mmo.app.spring5recipeapp.converter

import mmo.app.spring5recipeapp.commands.CategoryCommand
import mmo.app.spring5recipeapp.domain.Category
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CategoryCommandToCategory : Converter<CategoryCommand, Category> {

    @Synchronized
    override fun convert(source: CategoryCommand): Category {

        val category = Category()
        category.apply { id = source.id
        description = source.description}
        return category
    }
}