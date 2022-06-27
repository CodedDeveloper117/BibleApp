package com.cd.sdabibleapp.data.api.dtos

import kotlinx.serialization.Serializable

@Serializable
data class TitleData(
    val book: String,
    val chapter: String,
    val title: String,
    val verse: String
)