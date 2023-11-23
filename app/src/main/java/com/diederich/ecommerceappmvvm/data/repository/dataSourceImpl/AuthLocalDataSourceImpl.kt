package com.diederich.ecommerceappmvvm.data.repository.dataSourceImpl

import com.diederich.ecommerceappmvvm.data.datastore.AuthDatastore
import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.diederich.ecommerceappmvvm.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore): AuthLocalDataSource{
    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.save(authResponse)
    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()
}