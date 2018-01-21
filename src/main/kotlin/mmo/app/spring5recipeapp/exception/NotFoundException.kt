package mmo.app.spring5recipeapp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
open class NotFoundException(message: String?) : RuntimeException(message)
