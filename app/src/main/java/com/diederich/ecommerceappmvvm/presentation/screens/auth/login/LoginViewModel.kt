package com.diederich.ecommerceappmvvm.presentation.screens.auth.login

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():ViewModel() {

    var state by mutableStateOf(LoginState()) //esta sera una variable privada
        private set

    var errorMessage by mutableStateOf("")
        private set



    var isValidForm by mutableStateOf(false)
        private set
    fun onEmailInput(email: String){
       state = state.copy(email = email)
    }


    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }


    fun validateForm() = viewModelScope.launch {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es valido"
        } else if (state.password.length < 8) {
            errorMessage = "La constraseña debe tener al menos 8 caracteres"
        }

        delay(3000)
        errorMessage = ""//esto es para poder mostrar el otro mensaje es decir vaciarlo para que pueda verificar la siguiente condicion
    }

}

// es para que cuando se rota la pantalla los valor de los campos tanto de pass como de email permanezcan