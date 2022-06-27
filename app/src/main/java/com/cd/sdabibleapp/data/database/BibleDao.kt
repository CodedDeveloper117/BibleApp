package com.cd.sdabibleapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.cd.sdabibleapp.data.database.entities.Book
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

    @Insert
    suspend fun insertBook(book: Book)

}