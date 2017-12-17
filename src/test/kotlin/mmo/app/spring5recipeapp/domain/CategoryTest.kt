package mmo.app.spring5recipeapp.domain

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CategoryTest {

    lateinit var category: Category

    @Before
    fun setUp() {

        category = Category()

    }

    @Test
    fun getId() {
        val idValue = 4L
        category.apply { id = idValue }
        assertEquals(idValue, category.id)
    }

    @Test
    fun getDescription() {
    }

    @Test
    fun getRecipes() {
    }

}