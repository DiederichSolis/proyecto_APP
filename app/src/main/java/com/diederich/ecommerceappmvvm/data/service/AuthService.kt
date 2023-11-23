package com.diederich.ecommerceappmvvm.data.service

import com.diederich.ecommerceappmvvm.domain.model.AuthResponse
import com.diederich.ecommerceappmvvm.domain.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    //http://192.168.0.106:3000/auth/login
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email:String,
        @Field("password") password:String,
    ): Response<AuthResponse>


    @POST("auth/register") //as se establecio en el backend
    suspend fun register(
        @Body() user:User,
    ): Response<AuthResponse>



}