package com.cd.sdabibleapp.data.database

import androidx.room.*
import com.cd.sdabibleapp.data.database.entities.Book
import com.cd.sdabibleapp.data.database.entities.Verse
import com.cd.sdabibleapp.data.database.relations.BookWithChapters
import com.cd.sdabibleapp.data.database.relations.ChaptersWithVerses
import com.cd.sdabibleapp.data.database.relations.VersionWithBooks

@Dao
interface BibleDao {

    @Transaction
    @Query("SELECT * FROM chapter WHERE chapter = :chapter")
    suspend fun loadChaptersWithVerses(chapter: String): List<ChaptersWithVerses>

    @Transaction
    @Query("SELECT * FROM book WHERE book = :book")
    suspend fun loadBooksWithVerses(book: String): List<BookWithChapters>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: Book)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVerse(verse: Verse)

}