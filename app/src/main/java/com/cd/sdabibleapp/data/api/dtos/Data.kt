package com.cd.sdabibleapp.data.api.dtos

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val titleData: List<TitleData>,
    val verses: List<Verse>
)