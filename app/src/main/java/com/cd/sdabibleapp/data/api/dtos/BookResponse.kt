package com.cd.sdabibleapp.data.api.dtos

import com.cd.sdabibleapp.domain.models.BookInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookInfoResponse(
    @SerialName("abbr")
    val abbr: String,
    val book: String,
    val index: Int,
    @SerialName("noOfChapters")
    val chapters: Int
)

data class BookResponse(
    val data: List<BookInfoResponse>
)

fun BookInfoResponse.toBookInfo() = BookInfo(
    abbr, book, index, chapters
)