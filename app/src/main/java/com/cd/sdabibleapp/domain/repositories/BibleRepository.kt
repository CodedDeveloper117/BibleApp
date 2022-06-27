package com.cd.sdabibleapp.domain.repositories

import com.cd.sdabibleapp.domain.models.BookInfo
import com.cd.sdabibleapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface BibleRepository {
    suspend fun getBibleData(): Flow<Resource<Unit>>

    suspend fun loadChapterInfo(): Flow<Resource<Unit>>
}