package com.note.app.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.note.app.repositories.EditorNoteRepository
import com.note.app.viewmodel.NoteViewModel

class NoteViewModelFactory(private val repository: EditorNoteRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(repository) as T
    }
}
