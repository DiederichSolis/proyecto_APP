package com.diederich.ecommerceappmvvm.data.repository

import android.util.Log
import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.diederich.ecommerceappmvvm.domain.model.AuthResponse
import com.diederich.ecommerceappmvvm.domain.repository.AuthRepository
import com.diederich.ecommerceappmvvm.domain.util.Resoarce

class AuthRepositoryImpl (private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String, password: String): Resoarce<AuthResponse> {
        return  try {
            val result = authRemoteDataSource.login(email,password)
            Resoarce.Success(result.body()!!)
        }catch (e: Exception){
            Log.d("AuthRepositoryImpl","Error"+e)
            e.printStackTrace()
            Resoarce.Failure(e)
        }
    }


}