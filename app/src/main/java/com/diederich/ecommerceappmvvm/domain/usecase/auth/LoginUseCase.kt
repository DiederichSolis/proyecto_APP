package com.diederich.ecommerceappmvvm.domain.usecase.auth

import android.provider.ContactsContract.CommonDataKinds.Email
import com.diederich.ecommerceappmvvm.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository){

  suspend operator fun invoke(email: String,password: String) = repository.login(email,password)


}