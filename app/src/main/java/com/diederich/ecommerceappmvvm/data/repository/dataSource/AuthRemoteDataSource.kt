package com.diederich.ecommerceappmvvm.data.repository.dataSource

import com.diederich.ecommerceappmvvm.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email: String, password: String):Response<User>

}