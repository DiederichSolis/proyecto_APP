package com.diederich.ecommerceappmvvm.data.service

import com.diederich.ecommerceappmvvm.domain.model.User
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST

interface AuthService {

    //http:// 10.10.11.252:3000/auth/login
    @POST("auth/login")
    suspend fun login(
        @Field("email") email:String,
        @Field("password") password:String,
    ): Response<User>


}