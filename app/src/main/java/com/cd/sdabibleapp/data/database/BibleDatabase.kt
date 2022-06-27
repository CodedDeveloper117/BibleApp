package com.cd.sdabibleapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cd.sdabibleapp.data.database.entities.*


@Database(
    entities = [Book::class, Chapter::class, Verse::class, Version::class, TitleData::class],
    version = 1,
    exportSchema = false
)
abstract class BibleDatabase : RoomDatabase() {

    abstract val dao: BibleDao
}