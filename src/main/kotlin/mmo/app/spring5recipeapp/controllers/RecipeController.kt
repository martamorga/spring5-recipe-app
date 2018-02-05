package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.domain.Recipe
import mmo.app.spring5recipeapp.exception.NotFoundException
import mmo.app.spring5recipeapp.services.RecipeService
import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import javax.validation.Valid


@Controller
class RecipeController {

    companion object : KLogging()

    private val RECIPE_RECIPEFORM_URL = "recipe/recipeform"

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
    fun recipeSubmit(@Valid @ModelAttribute("recipe") recipe: Recipe, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) {

            bindingResult.allErrors.forEach { objectError -> logger.debug(objectError.toString()) }

            return RECIPE_RECIPEFORM_URL
        }

        recipeService.save(recipe)
        return "recipe/show"
    }

    @RequestMapping("/recipe/{id}/update")
    fun updateRecipe(@PathVariable id: String, model: Model): String {
        model.addAttribute("recipe", recipeService.findById(id.toLong()))
        return "recipe/recipeform"
    }

    @PostMapping("/recipe/{id}/update")
    fun recipeUpdate(@Valid @ModelAttribute("recipe") recipe: Recipe, model: Model): String {
        model.addAttribute("recipe", recipe)
        recipeService.save(recipe)
        return "recipe/show"
    }


    @GetMapping
    @RequestMapping("recipe/{id}/delete")
    fun deleteById(@PathVariable id: String): String {
        recipeService.deleteById(id.toLong())
        return "redirect:/"
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(exception: Exception): ModelAndView {

        logger.error("Handling not found exception")
        logger.error(exception.message)

        val modelAndView = ModelAndView()

        modelAndView.viewName = "404error"
        modelAndView.addObject("exception", exception)

        return modelAndView
    }
}