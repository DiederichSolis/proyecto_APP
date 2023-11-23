package com.diederich.ecommerceappmvvm.domain.repository

import com.diederich.ecommerceappmvvm.domain.model.AuthResponse
import com.diederich.ecommerceappmvvm.domain.util.Resoarce

interface AuthRepository {

    suspend fun login(email: String, password: String): Resoarce<AuthResponse>



}