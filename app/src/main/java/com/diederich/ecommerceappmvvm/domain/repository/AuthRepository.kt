package com.diederich.ecommerceappmvvm.domain.repository

import com.diederich.ecommerceappmvvm.domain.model.User

interface AuthRepository {

    suspend fun login(email: String, password: String): Result<User>



}