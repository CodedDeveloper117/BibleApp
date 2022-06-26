package com.cd.sdabibleapp.domain.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.cd.sdabibleapp.domain.models.Book
import com.cd.sdabibleapp.domain.models.Chapter

data class BookWithChapters(
    @Embedded val book: Book,
    @Relation(
        parentColumn = "book",
        entityColumn = "book"
    )
    val chapters: List<Chapter>
)
