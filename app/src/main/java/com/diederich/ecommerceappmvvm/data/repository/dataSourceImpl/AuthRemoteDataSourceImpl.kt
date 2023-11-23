package com.diederich.ecommerceappmvvm.data.repository.dataSourceImpl

import android.provider.ContactsContract.CommonDataKinds.Email
import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.diederich.ecommerceappmvvm.data.service.AuthService
import com.diederich.ecommerceappmvvm.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource{


    override suspend fun login(email: String, password: String)= authService.login(email, password)


}