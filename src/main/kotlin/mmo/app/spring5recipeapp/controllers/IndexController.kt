package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.repositories.CategoryRepository
import mmo.app.spring5recipeapp.repositories.UnitOfMeasureRepository
import mmo.app.spring5recipeapp.services.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController{

    @Autowired
    private lateinit var recipeService: RecipeService

    @RequestMapping("", "/", "/index")
    fun getIndexPage(model: Model): String{

        model.addAttribute("recipes", recipeService.getRecipes())

        return "index"
    }
}