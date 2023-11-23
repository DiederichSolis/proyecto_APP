package com.diederich.ecommerceappmvvm.domain.usecase.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase


)
