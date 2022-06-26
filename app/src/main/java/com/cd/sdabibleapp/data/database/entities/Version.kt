package com.cd.sdabibleapp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Version(
    @PrimaryKey(autoGenerate = false)
    val title: String
)
