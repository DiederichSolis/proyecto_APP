package com.diederich.ecommerceappmvvm.data.repository

import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.diederich.ecommerceappmvvm.domain.model.AuthResponse
import com.diederich.ecommerceappmvvm.domain.model.ErrorResponse
import com.diederich.ecommerceappmvvm.domain.model.User
import com.diederich.ecommerceappmvvm.domain.repository.AuthRepository
import com.diederich.ecommerceappmvvm.domain.util.ConvertErrorBody
import com.diederich.ecommerceappmvvm.domain.util.Resource
import com.diederich.ecommerceappmvvm.domain.util.ResponseToRequest
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl (private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(email, password)
    )

    override suspend fun register(user: User): Resource<AuthResponse>  = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )
}