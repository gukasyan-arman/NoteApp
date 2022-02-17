package com.example.roommvvm.screens.start

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roommvvm.REPOSITORY
import com.example.roommvvm.db.NoteDatabase
import com.example.roommvvm.db.repository.NoteRealization
import com.example.roommvvm.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }

}