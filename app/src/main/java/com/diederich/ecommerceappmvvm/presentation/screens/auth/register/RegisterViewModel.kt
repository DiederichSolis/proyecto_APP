package com.diederich.ecommerceappmvvm.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    var state by mutableStateOf(RegisterState())


    var errorMessage by mutableStateOf("")
        private set


    fun onNameInput(input: String){
        state = state.copy(name = input)
    }

    fun onLastnameInput(input: String){
        state = state.copy(lastname = input)
    }

    fun onEmailInput(input: String){
        state = state.copy(email = input)
    }

    fun onPhoneInput(input: String){
        state = state.copy(phone = input)
    }

    fun onPasswordInput(input: String){
        state = state.copy(password = input)
    }

    fun onConfirmPasswordInput(input: String){
        state = state.copy(confirmPassword = input)
    }


    fun validateForm() = viewModelScope.launch {

        if (state.name == ""){ //verificar que el campo nombre no este vacio
            errorMessage = "Ingresa el nombre"

        }

        else if (state.lastname == ""){ //verificar que el campo nombre no este vacio
            errorMessage = "Ingresa el apellido"

        }


        else if (state.email == ""){ //verificar que el campo nombre no este vacio
            errorMessage = "Ingresa el email"

        }

        else if (state.phone == ""){ //verificar que el campo nombre no este vacio
            errorMessage = "Ingresa el numero"

        }



        else if (state.password == ""){ //verificar que el campo nombre no este vacio
            errorMessage = "Ingresa la contraseña"

        }

        else if (state.confirmPassword == ""){ //verificar que el campo nombre no este vacio
            errorMessage = "Ingresa la contraseña de confirmacion"

        }

        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es valido"
        }

        else if (state.password.length < 8) {
            errorMessage = "La constraseña debe tener al menos 8 caracteres"
        }

        else if (state.password != state.confirmPassword){
            errorMessage = "Las contraseñas no coinciden"
        }

        delay(3000)
        errorMessage = ""//esto es para poder mostrar el otro mensaje es decir vaciarlo para que pueda verificar la siguiente condicion
    }
}