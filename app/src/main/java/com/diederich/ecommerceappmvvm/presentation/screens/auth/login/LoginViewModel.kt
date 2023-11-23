package com.diederich.ecommerceappmvvm.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diederich.ecommerceappmvvm.domain.model.AuthResponse
import com.diederich.ecommerceappmvvm.domain.usecase.auth.AuthUseCase
import com.diederich.ecommerceappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val  authUseCase: AuthUseCase):ViewModel() {

    var state by mutableStateOf(LoginState()) //esta sera una variable privada
        private set

    var errorMessage by mutableStateOf("")


    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set


    init {
        getSessionData()
    }
    fun getSessionData()=viewModelScope.launch {
        authUseCase.getSessionData().collect(){ data ->
            if (!data.token.isNullOrBlank()){
              loginResponse = Resource.Success(data)
           }

        }
    }
    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun login() = viewModelScope.launch {
        if (isValidForm()){
            loginResponse = Resource.Loading //Se espera una respuesta
            val result = authUseCase.login(state.email,state.password) //retorna una respuesta
            loginResponse = result // se verifica si es exitosa o marca error
            Log.d("LoginViewModel", "Response: ${loginResponse}")

        }
     }
    fun onEmailInput(email: String){
       state = state.copy(email = email)
    }


    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }


    fun isValidForm(): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es valido"
            return false
        } else if (state.password.length < 6) {
            errorMessage = "La constraseña debe tener al menos 8 caracteres"
            return false
        }

        return true
        }

}

// es para que cuando se rota la pantalla los valor de los campos tanto de pass como de email permanezcan