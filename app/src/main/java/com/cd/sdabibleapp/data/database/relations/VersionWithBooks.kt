package com.cd.sdabibleapp.data.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.cd.sdabibleapp.data.database.entities.Book
import com.cd.sdabibleapp.data.database.entities.Version

data class VersionWithBooks(
    @Embedded val version: Version,
    @Relation(
        parentColumn = "version",
        entityColumn = "version"
    )
    val books: List<Book>
)
