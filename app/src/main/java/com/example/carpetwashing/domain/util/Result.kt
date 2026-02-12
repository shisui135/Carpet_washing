package com.example.carpetwashing.domain.util

sealed interface Result<out T> {
    data class Success<out T>(val msg: String = "", val data: T? = null) : Result<T>
    data class Failure<out T>(val msg: String = "", val data: T? = null) : Result<T>
}
