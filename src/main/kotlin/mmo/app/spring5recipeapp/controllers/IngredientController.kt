package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.domain.Ingredient
import mmo.app.spring5recipeapp.domain.Recipe
import mmo.app.spring5recipeapp.services.IngredientService
import mmo.app.spring5recipeapp.services.RecipeService
import mmo.app.spring5recipeapp.services.UnitOfMeasureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class IngredientController {

    @Autowired
    private lateinit var recipeService: RecipeService

    @Autowired
    private lateinit var ingredientService: IngredientService

    @Autowired
    private lateinit var unitOfMeasureService: UnitOfMeasureService

    //mapowania dla składnikow - wszystkie

    @GetMapping
    @RequestMapping("ingredient/{id}/delete")
    fun showDetailsOfRecipe(@PathVariable id: String, model: Model): String {

        model.addAttribute("ingredient", ingredientService.deleteById(id.toLong()))
        return "redirect:/ingredients"
    }

    @GetMapping
    @RequestMapping("/ingredient/{id}/update")
    fun updateIngredientInList(@PathVariable id: String, model: Model): String {
        model.addAttribute("ingredient", ingredientService.findOneIngredient(id.toLong()))
        model.addAttribute("uomList", unitOfMeasureService.findAllUnitOfMeasures())
        return "recipe/ingredient/ingredientform"
    }

    @PostMapping("/ingredient/{id}/update")
    fun updateIngredientInList(@ModelAttribute("ingredient") ingredient: Ingredient,
                               model: Model): String {
        model.addAttribute("ingredient", ingredient)
        ingredientService.save(ingredient)
        return "recipe/ingredient/show"
    }

    // mapowania dla składników - konkretne przepisy
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

    @RequestMapping("recipe/{recipeId}/ingredient/{id}/update")
    fun updateRecipe(@PathVariable recipeId: String,
                     @PathVariable id: String,
                     model: Model): String {
        model.addAttribute("recipe", recipeService.findById(recipeId.toLong()))
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(recipeId.toLong(), id.toLong()))
        model.addAttribute("uomList", unitOfMeasureService.findAllUnitOfMeasures())
        return "recipe/ingredient/ingredientform"
    }

    @PostMapping("recipe/{recipeId}/ingredient/{id}/update")
    fun recipeUpdate(@ModelAttribute recipe: Recipe,
                     @ModelAttribute id: String,
                     @ModelAttribute("ingredient") ingredient: Ingredient,
                     model: Model): String {
        model.addAttribute("ingredient", ingredientService.save(ingredient))
        return "recipe/ingredient/show"
    }

}