package com.cd.sdabibleapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cd.sdabibleapp.data.database.entities.Book
import com.cd.sdabibleapp.data.database.entities.Chapter
import com.cd.sdabibleapp.data.database.entities.Verse
import com.cd.sdabibleapp.data.database.entities.Version


@Database(
    entities = [Book::class, Chapter::class, Verse::class, Version::class],
    version = 1,
    exportSchema = false
)
abstract class BibleDatabase : RoomDatabase() {

    abstract val dao: BibleDao
}