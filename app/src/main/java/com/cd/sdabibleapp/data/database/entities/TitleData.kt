package com.cd.sdabibleapp.data.database.entities

import androidx.room.Entity

@Entity
data class TitleData(
    val book: String,
    val chapter: Int,
    val verse: Int,
    val title: String
)
