package mmo.app.spring5recipeapp.services

import mmo.app.spring5recipeapp.domain.UnitOfMeasure

interface UnitOfMeasureService {

    fun findAllUnitOfMeasures(): Set<UnitOfMeasure>
}