package mmo.app.spring5recipeapp.controllers

import mmo.app.spring5recipeapp.services.ImageService
import mmo.app.spring5recipeapp.services.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

@Controller
class ImageController {

    @Autowired
    private lateinit var imageService: ImageService

    @Autowired
    private lateinit var recipeService: RecipeService


    @GetMapping("recipe/{id}/image")
    fun showUploadForm(@PathVariable id: String, model: Model): String {
        model.addAttribute("recipe", recipeService.findById(id.toLong()))

        return "recipe/imageuploadform"
    }

    @PostMapping("recipe/{id}/image")
    fun handleImagePost(@PathVariable id: String, @RequestParam("imagefile") file: MultipartFile): String {

        imageService.saveImageFile(id.toLong(), file)

        return "redirect:/recipe/$id/show"
    }
}