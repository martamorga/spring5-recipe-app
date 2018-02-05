package mmo.app.spring5recipeapp.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.ModelAndView

@ControllerAdvice
class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException::class)
    fun handleNumberFormat(exception: Exception): ModelAndView {

        RecipeController.logger.error("Handling Number Format Exception")
        RecipeController.logger.error(exception.message)

        val modelAndView = ModelAndView()

        modelAndView.viewName = "400error"
        modelAndView.addObject("exception", exception)

        return modelAndView
    }
}