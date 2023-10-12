package com.diederich.ecommerceappmvvm.presentation.navigation.screen

sealed class AuthScreen(val route: String){
    object Login: AuthScreen(route = "login")
    object Register: AuthScreen(route = "register")
}
