package mmo.app.spring5recipeapp.commands

import mmo.app.spring5recipeapp.domain.Difficulty
import java.util.*

class RecipeCommand {
    val id: Long = 0
    val description: String = ""
    val prepTime: Int = 0
    val cookTime: Int = 0
    val servings: Int = 0
    val source: String = ""
    val url: String = ""
    val directions: String = ""
    val ingredients = HashSet<IngredientCommand>()
    val difficulty: Difficulty = Difficulty.MODERATE
    val notes: NotesCommand = NotesCommand()
    val categories = HashSet<CategoryCommand>()
}