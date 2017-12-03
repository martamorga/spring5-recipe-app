package mmo.app.spring5recipeapp.repositories

import mmo.app.spring5recipeapp.domain.UnitOfMeasure
import org.springframework.data.repository.CrudRepository

interface UnitOfMeasureRepository : CrudRepository<UnitOfMeasure, Long> {

    fun findByDescription(description: String): UnitOfMeasure
}