package mmo.app.spring5recipeapp.bootstrap

import mmo.app.spring5recipeapp.domain.*
import mmo.app.spring5recipeapp.repositories.CategoryRepository
import mmo.app.spring5recipeapp.repositories.RecipeRepository
import mmo.app.spring5recipeapp.repositories.UnitOfMeasureRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import java.math.BigDecimal

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

    fun getRecipes(): List<Recipe> {

        val each = unitOfMeasureRepository.findByDescription("Each") ?: throw Exception("BLAD")
        val tableSpoon = unitOfMeasureRepository.findByDescription("Tablespoon") ?: throw Exception("BLAD")
        val teaSpoon = unitOfMeasureRepository.findByDescription("Teaspoon")
        val dash = unitOfMeasureRepository.findByDescription("Dash")
        val pint = unitOfMeasureRepository.findByDescription("Pint")
        val cups = unitOfMeasureRepository.findByDescription("Cup")

        val eachUom = each.description
        val tableSpoonUom = tableSpoon.description
        val dashUom = dash.description
        val pintUom = pint.description
        val cupsUom = cups.description
        val teaSpoonUom = teaSpoon.description

        val americanCategory = categoryRepository.findByDescription("American")

        val americanCategoryC = americanCategory.description

        val guacRecipe = Recipe()

        val guacNotes = Notes().apply {
            recipeNotes = "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n"
        }

        val i1 = Ingredient().apply {
            description = "ripe avocados"
            amount = BigDecimal(1)
            unitOfMeasure = UnitOfMeasure().apply { description = eachUom }
            recipe = guacRecipe
        }

        val i2 = Ingredient().apply {
            description = "Kosher salt"
            amount = BigDecimal(0.5)
            unitOfMeasure = UnitOfMeasure().apply { description = teaSpoonUom }
            recipe = guacRecipe
        }

        val i3 = Ingredient().apply {
            description = "fresh lime juice or lemon juice"
            amount = BigDecimal(2)
            unitOfMeasure = UnitOfMeasure().apply { description = tableSpoonUom }
            recipe = guacRecipe
        }

        val i4 = Ingredient().apply {
            description = "serrano chiles, stems and seeds removed, minced"
            amount = BigDecimal(2)
            unitOfMeasure = UnitOfMeasure().apply { description = eachUom }
            recipe = guacRecipe
        }


        guacRecipe.apply {
            description = "Perfect Guacamole"
            prepTime = 10
            cookTime = 5
            difficulty = Difficulty.EASY
            description = "1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon"
            notes = guacNotes
            ingredients = setOf(i1, i2, i3, i4)
            categories = setOf(americanCategory)
        }


        val recipes = listOf(guacRecipe)

        return recipes

    }

}