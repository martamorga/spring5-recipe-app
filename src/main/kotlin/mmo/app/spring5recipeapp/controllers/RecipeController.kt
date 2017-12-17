package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.services.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
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

}