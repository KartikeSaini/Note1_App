package com.note.app.repositories

import com.note.app.pojo.Note

interface EditorNoteRepository {

    fun submitNote(note: Note)
    fun updateNote(noteItem: Note)
}