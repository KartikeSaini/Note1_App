package com.note.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.note.app.pojo.Note
import com.note.app.repositories.EditorNoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(val repository: EditorNoteRepository) : ViewModel() {

    fun submitNote(note: Note){
        viewModelScope.launch {
            repository.submitNote(note)
        }
    }

    fun updateNote(noteItem: Note) {

        repository.updateNote(noteItem)
    }

}