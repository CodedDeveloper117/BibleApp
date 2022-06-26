package com.cd.sdabibleapp.data.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.cd.sdabibleapp.data.database.entities.Chapter
import com.cd.sdabibleapp.data.database.entities.Verse

data class ChaptersWithVerses(
    @Embedded val chapter: Chapter,
    @Relation(
        parentColumn = "chapter",
        entityColumn = "chapter"
    )
    val verses: List<Verse>
)
