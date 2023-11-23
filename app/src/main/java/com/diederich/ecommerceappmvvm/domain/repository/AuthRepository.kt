package com.diederich.ecommerceappmvvm.domain.repository

import com.diederich.ecommerceappmvvm.domain.model.AuthResponse
import com.diederich.ecommerceappmvvm.domain.model.User
import com.diederich.ecommerceappmvvm.domain.util.Resource

interface AuthRepository {

    suspend fun login(email: String, password: String): Resource<AuthResponse>

    suspend fun register(user: User): Resource<AuthResponse> // metodo que permite registrarse


}