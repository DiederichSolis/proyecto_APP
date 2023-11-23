package com.diederich.ecommerceappmvvm.data.repository

import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.diederich.ecommerceappmvvm.domain.model.User
import com.diederich.ecommerceappmvvm.domain.repository.AuthRepository
import com.diederich.ecommerceappmvvm.domain.repository.Result

class AuthRepositoryImpl (private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String, password: String): Result<User> {
        return  try {
            val result = authRemoteDataSource.login(email,password)
            Result.Success(result.body()!!)
        }catch (e: Exception){
            e.printStackTrace()
            Result.Failure(e)
        }
    }


}