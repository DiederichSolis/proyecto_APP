package com.diederich.ecommerceappmvvm.data.repository

import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.diederich.ecommerceappmvvm.domain.model.User
import com.diederich.ecommerceappmvvm.domain.repository.AuthRepository
import com.diederich.ecommerceappmvvm.domain.util.Response

class AuthRepositoryImpl (private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String, password: String): Response<User> {
        return  try {
            val result = authRemoteDataSource.login(email,password)
            Response.Success(result.body()!!)
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }


}