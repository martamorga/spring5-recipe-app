package mmo.app.spring5recipeapp.converter

import mmo.app.spring5recipeapp.commands.NotesCommand
import mmo.app.spring5recipeapp.domain.Notes
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class NotesToNotesCommand : Converter<Notes, NotesCommand> {

    @Synchronized
    override fun convert(source: Notes): NotesCommand {

        val notesCommand = NotesCommand()
        notesCommand.apply({
            source.id
            source.recipeNotes
        })
        return notesCommand
    }
}