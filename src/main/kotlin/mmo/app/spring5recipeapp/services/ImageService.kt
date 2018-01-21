package mmo.app.spring5recipeapp.services

import org.springframework.web.multipart.MultipartFile

interface ImageService {

    fun saveImageFile(recipeId: Long, file: MultipartFile)
}