package dev.sagar.jetpackcomposepokedex.util

sealed class Resource<out T> {
    data class Loading(val message: String? = "") : Resource<Nothing>()
    data class Success<T>(val data: T, val message: String = "") : Resource<T>()
    data class Error<T>(val error: Throwable?, val message: String = "") : Resource<T>()
}
