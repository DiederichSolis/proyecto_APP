package com.diederich.ecommerceappmvvm.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diederich.ecommerceappmvvm.domain.model.AuthResponse
import com.diederich.ecommerceappmvvm.domain.model.User
import com.diederich.ecommerceappmvvm.domain.usecase.auth.AuthUseCase
import com.diederich.ecommerceappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    var errorMessage by mutableStateOf("")


    fun register() = viewModelScope.launch{
        if (isvalidForm()){
            val user = User(
                name = state.name,
                lastname = state.lastname,
                phone = state.phone,
                email = state.email,
                password = state.password
            )
            registerResponse= Resource.Loading
            val result = authUseCase.register(user)
            registerResponse = result
        }

    }
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


    fun isvalidForm(): Boolean {

        if (state.name == ""){ //verificar que el campo nombre no este vacio
            errorMessage = "Ingresa el nombre"
            return false

        }

        else if (state.lastname == ""){ //verificar que el campo nombre no este vacio
            errorMessage = "Ingresa el apellido"
            return false
        }


        else if (state.email == ""){ //verificar que el campo nombre no este vacio
            errorMessage = "Ingresa el email"
            return false
        }

        else if (state.phone == ""){ //verificar que el campo nombre no este vacio
            errorMessage = "Ingresa el numero"
            return false
        }



        else if (state.password == ""){ //verificar que el campo nombre no este vacio
            errorMessage = "Ingresa la contraseña"
            return false
        }

        else if (state.confirmPassword == ""){ //verificar que el campo nombre no este vacio
            errorMessage = "Ingresa la contraseña de confirmacion"
            return false
        }

        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es valido"
            return false
        }

        else if (state.password.length < 6) {
            errorMessage = "La constraseña debe tener al menos 8 caracteres"
            return false
        }

        else if (state.password != state.confirmPassword){
            errorMessage = "Las contraseñas no coinciden"
            return false
        }

        return true
    }
}