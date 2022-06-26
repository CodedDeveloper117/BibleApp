package com.cd.sdabibleapp.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.cd.sdabibleapp.domain.relations.BookWithChapters
import com.cd.sdabibleapp.domain.relations.ChaptersWithVerses
import com.cd.sdabibleapp.domain.relations.VersionWithBooks

@Dao
interface BibleDao {
    @Transaction
    @Query("SELECT * FROM verse WHERE chapter = :chapter")
    suspend fun getVersesWithChapter(chapter: String): List<ChaptersWithVerses>

    @Transaction
    @Query("SELECT * FROM chapter WHERE book = :book")
    suspend fun getChaptersWithBooks(book: String): List<BookWithChapters>

    @Transaction
    @Query("SELECT * FROM version WHERE title = :version")
    suspend fun getBooksWithVersions(version: String): List<VersionWithBooks>

}