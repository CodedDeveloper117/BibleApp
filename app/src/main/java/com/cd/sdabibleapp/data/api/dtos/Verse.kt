package com.cd.sdabibleapp.data.api.dtos

import kotlinx.serialization.Serializable

@Serializable
data class Verse(
    val book: String,
    val chapter: Int,
    val content: String,
    val verse_number: Int
)