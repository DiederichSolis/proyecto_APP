package com.diederich.ecommerceappmvvm.domain.usecase.auth

import com.diederich.ecommerceappmvvm.domain.model.User
import com.diederich.ecommerceappmvvm.domain.repository.AuthRepository

class RegisterUseCase(private val repository: AuthRepository){

    suspend  operator fun invoke(user: User) = repository.register(user)
}