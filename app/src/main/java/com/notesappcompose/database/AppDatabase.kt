package com.notesappcompose.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.notesappcompose.dao.NoteDao
import com.notesappcompose.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}