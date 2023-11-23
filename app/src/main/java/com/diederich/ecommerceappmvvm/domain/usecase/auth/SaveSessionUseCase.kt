package com.diederich.ecommerceappmvvm.domain.usecase.auth

import com.diederich.ecommerceappmvvm.domain.model.AuthResponse
import com.diederich.ecommerceappmvvm.domain.repository.AuthRepository

class SaveSessionUseCase constructor(private val repository: AuthRepository){
suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)

}