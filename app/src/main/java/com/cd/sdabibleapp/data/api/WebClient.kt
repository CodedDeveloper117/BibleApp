package com.cd.sdabibleapp.data.api

import android.util.Log
import com.cd.sdabibleapp.data.api.dtos.BookResponse
import com.cd.sdabibleapp.data.utils.BASE_URL
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val TAG = "WebClient"

class WebClient(
    private val client: HttpClient
) {

    suspend fun getBibleData(): Either<Failure, List<BookResponse>> {
        return try {
            val url = "$BASE_URL/bible/data"
            val response = client.request<List<BookResponse>>(url) {
                method = HttpMethod.Get
            }
            Either.Right(response)
        }catch (e: Exception) {
            Either.Left(e.catchExceptions())
        }
    }

}

sealed class Either<Error, Response> {
    data class Right<Error, Response>(val response: Response): Either<Error, Response>()
    data class Left<Error, Response>(val error: Error): Either<Error, Response>()
}

fun Exception.catchExceptions() = when(this) {
    is ServerResponseException -> Failure.HttpErrorInternalServerError(this)
    is ClientRequestException -> {
        when(this.response.status.value) {
            400 -> Failure.HttpErrorBadRequest(this)
            401 -> Failure.HttpErrorUnauthorized(this)
            403 -> Failure.HttpErrorForbidden(this)
            404 -> Failure.HttpErrorNotFound(this)
            else -> Failure.HttpError(this)
        }
    }
    is RedirectResponseException -> Failure.HttpError(this)
    else -> Failure.GenericError(this)
}

sealed class Failure(
    e: Exception
): Exception(e.message) {
    data class HttpErrorInternalServerError(val e: Exception): Failure(e)
    data class GenericError(val e: Exception): Failure(e)
    data class HttpErrorBadRequest(val e: Exception): Failure(e)
    data class HttpErrorUnauthorized(val e: Exception): Failure(e)
    data class HttpErrorForbidden(val e: Exception): Failure(e)
    data class HttpErrorNotFound(val e: Exception): Failure(e)
    data class HttpError(val e: Exception): Failure(e)
}