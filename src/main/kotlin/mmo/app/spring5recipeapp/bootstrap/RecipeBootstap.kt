package mmo.app.spring5recipeapp.bootstrap

import mmo.app.spring5recipeapp.domain.Recipe
import mmo.app.spring5recipeapp.repositories.CategoryRepository
import mmo.app.spring5recipeapp.repositories.RecipeRepository
import mmo.app.spring5recipeapp.repositories.UnitOfMeasureRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class RecipeBootstrap : ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    @Autowired
    lateinit var recipeRepository: RecipeRepository

    @Autowired
    lateinit var unitOfMeasureRepository: UnitOfMeasureRepository

    override fun onApplicationEvent(p0: ContextRefreshedEvent?) {
        recipeRepository.save(getRecipes())//To change body of created functions use File | Settings | File Templates.
    }

    fun getRecipes(): List<Recipe>{

        var recipes = listOf(Recipe())

////        var eachUom = unitOfMeasureRepository.findByDescription("Each")
////
////        println(eachUom)
////
////        if ((eachUom.description!=("Each"))) {
////            throw RuntimeException("Expected UOM Not Found")
////        }

        return recipes
    }

}