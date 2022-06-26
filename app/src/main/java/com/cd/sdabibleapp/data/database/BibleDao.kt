package com.cd.sdabibleapp.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.cd.sdabibleapp.data.database.relations.BookWithChapters
import com.cd.sdabibleapp.data.database.relations.ChaptersWithVerses
import com.cd.sdabibleapp.data.database.relations.VersionWithBooks

@Dao
interface BibleDao {

    @Transaction
    @Query("SELECT * FROM chapter WHERE chapter = :chapter")
    suspend fun getVersesWithChapter(chapter: String): List<ChaptersWithVerses>

    @Transaction
    @Query("SELECT * FROM book WHERE book = :book")
    suspend fun getChaptersWithBooks(book: String): List<BookWithChapters>

}