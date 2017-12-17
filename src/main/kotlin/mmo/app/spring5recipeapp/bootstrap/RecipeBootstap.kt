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
class RecipeBootstap : ApplicationListener<ContextRefreshedEvent> {

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
        val teaSpoon = unitOfMeasureRepository.findByDescription("Teaspoon") ?: throw Exception("BLAD")
        val dash = unitOfMeasureRepository.findByDescription("Dash") ?: throw Exception("BLAD")
        val pint = unitOfMeasureRepository.findByDescription("Pint") ?: throw Exception("BLAD")
        val cups = unitOfMeasureRepository.findByDescription("Cup") ?: throw Exception("BLAD")

        val dashUom = dash.description
        val pintUom = pint.description
        val cupsUom = cups.description

        val americanCategory = categoryRepository.findByDescription("American")
        val mexicanCategory = categoryRepository.findByDescription("Mexican")

        val guacRecipe = Recipe()

        val guacNotes = Notes().apply {
            recipeNotes = "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                    "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                    "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                    "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                    "\n" +
                    "\n" +
                    "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws"
        }

        val i1g = Ingredient().apply {
            description = "ripe avocados"
            amount = BigDecimal(1)
            unitOfMeasure = UnitOfMeasure().apply { description = each.description }
            recipe = guacRecipe
        }

        val i2g = Ingredient().apply {
            description = "Kosher salt"
            amount = BigDecimal(0.5)
            unitOfMeasure = UnitOfMeasure().apply { description = teaSpoon.description }
            recipe = guacRecipe
        }

        val i3g = Ingredient().apply {
            description = "fresh lime juice or lemon juice"
            amount = BigDecimal(2)
            unitOfMeasure = UnitOfMeasure().apply { description = tableSpoon.description }
            recipe = guacRecipe
        }

        val i4g = Ingredient().apply {
            description = "serrano chiles, stems and seeds removed, minced"
            amount = BigDecimal(2)
            unitOfMeasure = UnitOfMeasure().apply { description = each.description }
            recipe = guacRecipe
        }


        guacRecipe.apply {
            description = "Perfect Guacamole"
            prepTime = 10
            cookTime = 5
            difficulty = Difficulty.EASY
            directions = "1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                    "\n" +
                    "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                    "\n" +
                    "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                    "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                    "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                    "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                    "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                    "\n" +
                    "\n" +
                    "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd"
            notes = guacNotes
            ingredients = setOf(i1g, i2g, i3g, i4g)
            categories = setOf(americanCategory, mexicanCategory)
        }


        val tacosRecipe = Recipe()

        val tacoNotes = Notes().apply {
            recipeNotes = "We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                    "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                    "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                    "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                    "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                    "\n" +
                    "\n" +
                    "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ"
        }

        val i1t = Ingredient().apply {
            description = "Ancho Chili Powder"
            amount = BigDecimal(1)
            unitOfMeasure = UnitOfMeasure().apply { description = tableSpoon.description }
            recipe = tacosRecipe
        }

        val i2t = Ingredient().apply {
            description = "Dried Oregano"
            amount = BigDecimal(1)
            unitOfMeasure = UnitOfMeasure().apply { description = teaSpoon.description }
            recipe = tacosRecipe
        }


        val i3t = Ingredient().apply {
            description = "Dried Cumin"
            amount = BigDecimal(1)
            unitOfMeasure = UnitOfMeasure().apply { description = teaSpoon.description }
            recipe = tacosRecipe
        }

        val i4t = Ingredient().apply {
            description = "Sugar"
            amount = BigDecimal(1)
            unitOfMeasure = UnitOfMeasure().apply { description = teaSpoon.description }
            recipe = tacosRecipe
        }

        val i5t = Ingredient().apply {
            description = "Salt"
            amount = BigDecimal(0.5)
            unitOfMeasure = UnitOfMeasure().apply { description = each.description }
            recipe = tacosRecipe
        }

        val i6t = Ingredient().apply {
            description = "Clove of Garlic, Choppedr"
            amount = BigDecimal(1)
            unitOfMeasure = UnitOfMeasure().apply { description = teaSpoon.description }
            recipe = tacosRecipe
        }

        val i7t = Ingredient().apply {
            description = "finely grated orange zestr"
            amount = BigDecimal(1)
            unitOfMeasure = UnitOfMeasure().apply { description = tableSpoon.description }
            recipe = tacosRecipe
        }

        tacosRecipe.apply {
            description = "Spicy Grilled Chicken Taco"
            prepTime = 9
            cookTime = 12
            difficulty = Difficulty.MODERATE
            directions = "1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                    "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                    "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                    "\n" +
                    "\n" +
                    "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                    "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                    "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                    "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                    "\n" +
                    "\n" +
                    "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm"
            notes = tacoNotes
            ingredients = setOf(i1t, i2t, i3t, i4t, i5t, i6t, i7t)
            categories = setOf(americanCategory, mexicanCategory)
        }

        val recipes = listOf(guacRecipe, tacosRecipe)

        return recipes

    }

}