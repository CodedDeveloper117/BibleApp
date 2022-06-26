package com.cd.sdabibleapp.data.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    @SerialName("abbr")
    val abbr: String,
    val book: String,
    val index: Int,
    @SerialName("noOfChapters")
    val chapters: Int
)