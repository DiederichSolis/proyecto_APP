package com.diederich.ecommerceappmvvm.domain.model

data class AuthResponse(
    val user: User,
    val token: String
)
