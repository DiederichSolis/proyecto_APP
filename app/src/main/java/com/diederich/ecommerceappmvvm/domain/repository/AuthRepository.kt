package com.diederich.ecommerceappmvvm.domain.repository

import com.diederich.ecommerceappmvvm.domain.model.User
import com.diederich.ecommerceappmvvm.domain.util.Response

interface AuthRepository {

    suspend fun login(email: String, password: String): Response<User>



}