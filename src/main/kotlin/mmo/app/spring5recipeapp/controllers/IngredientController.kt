package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.domain.Ingredient
import mmo.app.spring5recipeapp.domain.Recipe
import mmo.app.spring5recipeapp.domain.UnitOfMeasure
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
                               @ModelAttribute("unitOfMeasure") uom: UnitOfMeasure,
                               model: Model): String {
        model.addAttribute("ingredient", ingredient)
        model.addAttribute("unitOfMeasure", uom)
        ingredientService.save(ingredient, uom)
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
                     @ModelAttribute("uomList") unitOfMeasure: UnitOfMeasure,
                     model: Model): String {

        model.addAttribute("uomList", unitOfMeasureService.save(unitOfMeasure))
        model.addAttribute("ingredient", ingredientService.save(ingredient, unitOfMeasure))
        return "recipe/ingredient/show"
    }

    @GetMapping("recipe/{recipeId}/ingredient/create")
    fun recipeForm(model: Model): String {
        val nowySkladnik = UnitOfMeasure()
        val nowyPrzepis = Ingredient().apply { unitOfMeasure = nowySkladnik }
        model.addAttribute("ingredient", nowyPrzepis)
        model.addAttribute("uomList", unitOfMeasureService.findAllUnitOfMeasures())
        model.addAttribute("unitOfMeasure", nowySkladnik)
        return "recipe/ingredient/ingredientform"
    }

    @PostMapping("recipe/{recipeId}/ingredient/create")
    fun recipeSubmit(@PathVariable recipeId: String,
                     @ModelAttribute("ingredient") ingredient: Ingredient,
                     @ModelAttribute("uomList") uomEach: UnitOfMeasure,
                     @ModelAttribute("unitOfMeasure") uom: UnitOfMeasure,
                     model: Model): String {
        model.addAttribute("ingredient", ingredient)
        model.addAttribute("uomList", uomEach)
        model.addAttribute("unitOfMeasure", uom)
        ingredientService.create(ingredient.apply {
            recipe = recipeService.findById(recipeId.toLong())
            unitOfMeasure = uom
        })
        return "recipe/ingredient/show"
    }

//    @RequestMapping("recipe/{recipeId}/ingredient/create")
//    fun createRecipe(@PathVariable recipeId: String,
//                     model: Model): String {
//        model.addAttribute("recipe", recipeService.findById(recipeId.toLong()))
//        model.addAttribute("ingredient", Ingredient())
//        model.addAttribute("uomList", unitOfMeasureService.findAllUnitOfMeasures())
//        return "recipe/ingredient/ingredientform"
//    }
//
//    @PostMapping("recipe/{recipeId}/ingredient/create")
//    fun createRecipe(@ModelAttribute recipe: Recipe,
//                     @ModelAttribute("ingredient") ingredient: Ingredient,
//                     @ModelAttribute("uomEach") uomEach: UnitOfMeasure,
//                     model: Model): String {
//        val desc= unitOfMeasureService.findByDescription(ingredient.unitOfMeasure!!.description)
//        model.addAttribute("ingredient", ingredientService.create(ingredient, desc))
//        return "recipe/ingredient/show"
//    }

}