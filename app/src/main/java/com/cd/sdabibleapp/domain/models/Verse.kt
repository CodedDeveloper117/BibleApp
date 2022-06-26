package com.cd.sdabibleapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Verse(
    @PrimaryKey(autoGenerate = false) val id: Int? = null,
    val content: String,
    val chapter: String,
    val book: String,
    val references: String = ""
)
