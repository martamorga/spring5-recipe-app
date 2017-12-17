package mmo.app.spring5recipeapp.repository

import junit.framework.Assert
import junit.framework.Assert.assertEquals
import mmo.app.spring5recipeapp.domain.Category
import mmo.app.spring5recipeapp.repositories.UnitOfMeasureRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    lateinit var unitOfMeasureRepository: UnitOfMeasureRepository

    @Before
    fun setUp() {
    }

    @Test
    fun findByDescription() {

        val uom =unitOfMeasureRepository.findByDescription("Pinch")
        assertEquals("Pinch", uom.description)
    }

}