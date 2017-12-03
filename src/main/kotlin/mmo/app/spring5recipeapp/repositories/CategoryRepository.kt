package mmo.app.spring5recipeapp.repositories

import mmo.app.spring5recipeapp.domain.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Long> {

    fun findByDescription(description: String): Category
}