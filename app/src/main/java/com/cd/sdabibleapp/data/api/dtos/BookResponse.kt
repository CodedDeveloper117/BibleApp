package com.cd.sdabibleapp.data.api.dtos

import com.cd.sdabibleapp.domain.models.BookInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    @SerialName("abbr")
    val abbr: String,
    val book: String,
    @SerialName("index")
    val id: Int,
    @SerialName("noOfChapters")
    val noOfChapters: Int = 0
)

fun BookResponse.toBookInfo() = BookInfo(
    abbr, book, id, noOfChapters
)