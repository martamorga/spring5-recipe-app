package mmo.app.spring5recipeapp.services

import mmo.app.spring5recipeapp.repositories.RecipeRepository
import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException

@Service
class ImageServiceImpl : ImageService {

    companion object : KLogging()

    @Autowired
    lateinit var recipeRepository: RecipeRepository


    override fun saveImageFile(recipeId: Long, file: MultipartFile) {

        logger.info("Mam obrazek!")
    }

    @Transactional
    fun saveImageFile(recipeId: Long?, file: File) {

        try {
            val recipe = recipeRepository.findOne(recipeId)

            recipe.apply { image = file.readBytes().first() }

            recipeRepository.save(recipe)
        } catch (e: IOException) {
            //todo handle better
            logger.error("Error occurred", e)

            e.printStackTrace()
        }

    }

}