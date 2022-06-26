package com.cd.sdabibleapp.data.repositories

import com.cd.sdabibleapp.data.api.Either
import com.cd.sdabibleapp.data.api.WebClient
import com.cd.sdabibleapp.data.api.dtos.toBookInfo
import com.cd.sdabibleapp.domain.models.BookInfo
import com.cd.sdabibleapp.domain.repositories.BibleRepository
import com.cd.sdabibleapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Singleton

@Singleton
class BibleRepositoryImpl(
    private val client: WebClient
): BibleRepository {
    override suspend fun getBibleData(): Flow<Resource<List<BookInfo>>> = flow {
        emit(Resource.Loading())
        when (val data = client.getBibleData()) {
            is Either.Right -> {
                val result = data.response.map {
                    it.toBookInfo()
                }
                emit(Resource.Success(result))
            }
            is Either.Left -> {
                emit(Resource.Failure(data.error.message))
            }
        }
    }
}