package org.app.siekraf.core.model
sealed class Output<out T> {
    data class Success<out T>(val data: T): Output<T>()
    data class Error(val exception : Throwable): Output<Nothing>()
    object Loading : Output<Nothing>()
}
