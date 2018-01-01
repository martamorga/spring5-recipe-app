package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.services.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

    @Autowired
    private lateinit var recipeService: RecipeService

    @RequestMapping("", "/", "/index")
    fun getIndexPage(model: Model): String {

        model.addAttribute("recipes", (recipeService.getRecipes()).sortedBy { it.id })

        return "index"
    }

}