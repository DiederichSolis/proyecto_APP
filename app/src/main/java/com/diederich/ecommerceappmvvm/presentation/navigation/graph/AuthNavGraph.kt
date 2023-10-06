package com.diederich.ecommerceappmvvm.presentation.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.diederich.ecommerceappmvvm.presentation.navigation.Graph
import com.diederich.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.diederich.ecommerceappmvvm.presentation.screens.auth.login.LoginScreeen
import com.diederich.ecommerceappmvvm.presentation.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route

    ){

        composable(route = AuthScreen.Login.route){
            LoginScreeen(navController)
        }

        composable(route = AuthScreen.Register.route){
            RegisterScreen()
        }
    }
}