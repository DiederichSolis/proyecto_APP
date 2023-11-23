package com.diederich.ecommerceappmvvm.domain.util

sealed class Resoarce<out  T>{

    object Loading: Resoarce<Nothing>()
    data class Success<out T>(val data: T): Resoarce<T>()
    data class Failure<out T>(val exception: Exception): Resoarce<T>()


}
