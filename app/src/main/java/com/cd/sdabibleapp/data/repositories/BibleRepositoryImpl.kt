package com.cd.sdabibleapp.data.repositories

import com.cd.sdabibleapp.data.api.Either
import com.cd.sdabibleapp.data.api.WebClient
import com.cd.sdabibleapp.data.api.dtos.toBookInfo
import com.cd.sdabibleapp.data.database.BibleDao
import com.cd.sdabibleapp.domain.models.BookInfo
import com.cd.sdabibleapp.domain.repositories.BibleRepository
import com.cd.sdabibleapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BibleRepositoryImpl @Inject constructor(
    private val client: WebClient,
    private val dao: BibleDao
) : BibleRepository {
    override suspend fun getBibleData(): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        when (val data = client.getBibleData()) {
            is Either.Right -> {
                val result = data.response.map {
                    it.toBookInfo()
                }
                result.map {

                }
                emit(Resource.Success(Unit))
            }
            is Either.Left -> {
                emit(Resource.Failure(data.error.message))
            }
        }
    }

    override suspend fun loadChapterInfo(): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())

    }

    private suspend fun loadChapterInfo(
        book: String,
        chapter: Int,
        version: String,
        callback: ((Boolean, String?) -> Unit)
    ) {

    }
}