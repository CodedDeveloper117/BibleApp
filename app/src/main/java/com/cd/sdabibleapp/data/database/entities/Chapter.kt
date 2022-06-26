package com.cd.sdabibleapp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Chapter(
    @PrimaryKey(autoGenerate = false) val id: Int? = null,
    val verses: Int,
    val book: String,
    val titles: String,
    val version: String
)
