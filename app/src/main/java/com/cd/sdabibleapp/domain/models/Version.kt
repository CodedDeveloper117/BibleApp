package com.cd.sdabibleapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Version(
    @PrimaryKey(autoGenerate = false)
    val title: String
)
