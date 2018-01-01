package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.domain.Recipe
import mmo.app.spring5recipeapp.services.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller
class RecipeController {

    @Autowired
    private lateinit var recipeService: RecipeService

    @RequestMapping("recipe/{id}/show")
    fun showById(@PathVariable id: Long, model: Model): String {

        recipeService.findById(id) ?: throw Exception("Nie znaleziono przepisu o podnaym id")

        model.addAttribute("recipe", recipeService.findById(id))

        return "recipe/show"
    }

    @GetMapping("/recipe/create")
    fun recipeForm(model: Model): String {
        model.addAttribute("recipe", Recipe())
        return "recipe/recipeform"
    }

    @PostMapping("/recipe/create")
    fun recipeSubmit(@ModelAttribute("recipe") recipe: Recipe, model: Model): String {
        model.addAttribute("recipe", recipe)
        recipeService.save(recipe)
        return "recipe/show"
    }

    @RequestMapping("/recipe/{id}/update")
    fun updateRecipe(@PathVariable id: String, model: Model): String {
        model.addAttribute("recipe", recipeService.findById(id.toLong()))
        return "recipe/recipeform"
    }

    @PostMapping("/recipe/{id}/update")
    fun recipeUpdate(@ModelAttribute("recipe") recipe: Recipe, model: Model): String {
        model.addAttribute("recipe", recipe)
        recipeService.save(recipe)
        return "recipe/show"
    }

}