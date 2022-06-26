package com.cd.sdabibleapp.domain.utils

sealed class Resource<T>(
    val error: String? = null,
    val data: T? = null,
    val loading: Boolean = false
) {
    class Loading<T>: Resource<T>(null, null, true)
    class Success<T>(data: T): Resource<T>(null, data, false)
    class Failure<T>(error: String?): Resource<T>(error, null, false)
}
