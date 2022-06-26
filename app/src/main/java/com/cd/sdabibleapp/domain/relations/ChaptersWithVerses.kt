package com.cd.sdabibleapp.domain.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.cd.sdabibleapp.domain.models.Chapter
import com.cd.sdabibleapp.domain.models.Verse

data class ChaptersWithVerses(
    @Embedded val chapter: Chapter,
    @Relation(
        parentColumn = "chapter",
        entityColumn = "chapter"
    )
    val verses: List<Verse>
)
