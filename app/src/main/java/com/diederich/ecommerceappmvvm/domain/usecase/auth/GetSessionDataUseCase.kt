package com.diederich.ecommerceappmvvm.domain.usecase.auth

import com.diederich.ecommerceappmvvm.domain.model.AuthResponse
import com.diederich.ecommerceappmvvm.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository:AuthRepository ){

 operator fun invoke() = repository.getSessionData()

}