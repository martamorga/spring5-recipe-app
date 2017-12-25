package mmo.app.spring5recipeapp.converter

import mmo.app.spring5recipeapp.commands.NotesCommand
import mmo.app.spring5recipeapp.domain.Notes
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class NotesCommandToNotes : Converter<NotesCommand, Notes> {

    @Synchronized
    override fun convert(source: NotesCommand): Notes {

        val notes = Notes()
        notes.apply {
            id = source.id
            recipeNotes = source.recipeNotes
        }
        return notes
    }
}
