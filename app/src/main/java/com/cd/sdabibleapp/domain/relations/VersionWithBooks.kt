package com.cd.sdabibleapp.domain.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.cd.sdabibleapp.domain.models.Book
import com.cd.sdabibleapp.domain.models.Version

data class VersionWithBooks(
    @Embedded val version: Version,
    @Relation(
        parentColumn = "version",
        entityColumn = "version"
    )
    val books: List<Book>
)
