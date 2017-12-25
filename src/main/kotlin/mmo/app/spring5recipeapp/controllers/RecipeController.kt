package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.commands.RecipeCommand
import mmo.app.spring5recipeapp.services.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class RecipeController {

    @Autowired
    private lateinit var recipeService: RecipeService

    @RequestMapping("recipe/show/{id}")
    fun showById(@PathVariable id: String, model: Model): String {

        model.addAttribute("recipe", recipeService.findById(id.toLong()))

        return "recipe/show"
    }

    @RequestMapping("recipe/new")
    fun newRecipe(model: Model): String {
        model.addAttribute("recipe", RecipeCommand())

        return "recipe/recipeform"
    }

    @PostMapping
    @RequestMapping("recipe")
    fun saveOrUpdate(@ModelAttribute command: RecipeCommand): String {
        val savedCommand = recipeService.saveRecipeCommand(command)

        return "redirect:/recipe/show/" + savedCommand.id
    }

}