package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.services.RecipeService
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.springframework.ui.Model

class IndexControllerTest {

    @Mock
    lateinit var recipeService: RecipeService

    @Mock
    lateinit var model: Model

    @Before
    fun setUp() {
    }

    @Test
    fun getIndexPage() {
    }

}