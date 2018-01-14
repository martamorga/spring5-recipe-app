package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.services.IngredientService
import mmo.app.spring5recipeapp.services.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

    @Autowired
    private lateinit var recipeService: RecipeService

    @Autowired
    private lateinit var ingredientSevice: IngredientService

    @RequestMapping("", "/", "/index")
    fun getIndexPage(model: Model): String {

        model.addAttribute("recipes", (recipeService.getRecipes()).sortedBy { it.id })

        return "index"
    }


    @RequestMapping("ingredients")
    fun getAllIngredients(model: Model): String {

        model.addAttribute("ingredients", (ingredientSevice.getIngredients()).sortedBy { it.id })

        return "recipe/ingredient/listall"
    }

}