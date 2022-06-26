package com.cd.sdabibleapp.data.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.cd.sdabibleapp.data.database.entities.Book
import com.cd.sdabibleapp.data.database.entities.Chapter

data class BookWithChapters(
    @Embedded val book: Book,
    @Relation(
        parentColumn = "book",
        entityColumn = "book"
    )
    val chapters: List<Chapter>
)
