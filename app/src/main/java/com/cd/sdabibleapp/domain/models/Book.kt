package com.cd.sdabibleapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book (
    @PrimaryKey(autoGenerate = false) val id: Int? = null,
    val book: String,
    val chapters: Int,
    val abbr: String,
    val version: String
)