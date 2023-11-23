package com.diederich.ecommerceappmvvm.data.repository.dataSource

import com.diederich.ecommerceappmvvm.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {



    suspend fun saveSession(authResponse: AuthResponse)
    fun getSessionData(): Flow<AuthResponse>
}