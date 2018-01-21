package mmo.app.spring5recipeapp.services

import mmo.app.spring5recipeapp.domain.UnitOfMeasure
import mmo.app.spring5recipeapp.repositories.UnitOfMeasureRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UnitOfMeasureServiceImpl : UnitOfMeasureService {


    @Autowired
    lateinit var unitOfMeasureRepository: UnitOfMeasureRepository

    override fun findAllUnitOfMeasures(): Set<UnitOfMeasure> = unitOfMeasureRepository.findAll().toList().distinctBy { it.description }.toHashSet()

    override fun findByDescription(description: String): UnitOfMeasure {
        return unitOfMeasureRepository.findByDescription(description)
    }

    override fun save(unitOfMeasure: UnitOfMeasure): UnitOfMeasure {
        return unitOfMeasureRepository.save(unitOfMeasure)
    }

}
