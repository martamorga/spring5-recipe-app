package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.services.IngredientService
import mmo.app.spring5recipeapp.services.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IngredientController {

    @Autowired
    private lateinit var recipeService: RecipeService

    @Autowired
    private lateinit var ingredientService: IngredientService

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    fun listIngredients(@PathVariable recipeId: String, model: Model): String {

        model.addAttribute("recipe", recipeService.findById(recipeId.toLong()))

        return "recipe/ingredient/list"
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/show")
    fun showRecipeIngredient(@PathVariable recipeId: String,
                             @PathVariable id: String, model: Model): String {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(recipeId.toLong(), id.toLong()))
        return "recipe/ingredient/show"
    }
}