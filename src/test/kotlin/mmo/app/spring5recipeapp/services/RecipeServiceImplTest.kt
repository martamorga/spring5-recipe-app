package mmo.app.spring5recipeapp.services

import junit.framework.Assert
import mmo.app.spring5recipeapp.domain.Recipe
import mmo.app.spring5recipeapp.repositories.RecipeRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RecipeServiceImplTest {

    private lateinit var recipeService: RecipeServiceImpl

    @Mock lateinit var recipeRepo: RecipeRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        recipeService = RecipeServiceImpl().apply { recipeRepo }
    }

    @Test
    fun getRecipes() {

        val recipes: Set<Recipe> = recipeService.getRecipes()
        Assert.assertEquals(recipes.size, 8)

    }

}