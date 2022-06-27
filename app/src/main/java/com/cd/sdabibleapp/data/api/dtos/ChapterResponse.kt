package com.cd.sdabibleapp.data.api.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ChapterResponse(
    val book: String,
    val chapter: String,
    val data: Data,
    val version: String
)