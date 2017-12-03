package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.repositories.CategoryRepository
import mmo.app.spring5recipeapp.repositories.UnitOfMeasureRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController{

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    @Autowired
    lateinit var unitOfMeasureRepository: UnitOfMeasureRepository

    @RequestMapping("", "/", "/index")
    fun getIndexPage(): String{

        val categoryOptional = categoryRepository.findByDescription("American")
        val unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon")

        System.out.println("Cat Id is: " + categoryOptional.id)
        System.out.println("UOM ID is: " + unitOfMeasureOptional.id)


        return "index"
    }
}