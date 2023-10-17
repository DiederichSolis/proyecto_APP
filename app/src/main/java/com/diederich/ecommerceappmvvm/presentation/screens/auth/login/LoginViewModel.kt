package com.diederich.ecommerceappmvvm.presentation.screens.auth.login

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():ViewModel() {

    var email by   mutableStateOf(value = "")
    var password   by  mutableStateOf(value = "")



}
// es para que cuando se rota la pantalla los valor de los campos tanto de pass como de email permanezcan