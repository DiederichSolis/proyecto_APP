package com.diederich.ecommerceappmvvm.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.diederich.ecommerceappmvvm.domain.util.Resource
import com.diederich.ecommerceappmvvm.presentation.components.ProgressBar
import com.diederich.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.diederich.ecommerceappmvvm.presentation.screens.auth.login.LoginViewModel


@Composable
fun Login(navController: NavHostController, vm: LoginViewModel = hiltViewModel()){

    when(val response = vm.loginResponse){
        Resource.Loading -> {
           ProgressBar()
        }
         is Resource.Success -> { // se coloca ya que son data class y no objetos
            LaunchedEffect(Unit){
                vm.saveSession(response.data)
                navController.navigate(route = AuthScreen.Home.route)
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message , Toast.LENGTH_SHORT).show()

        }
        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current, "Hubo un erro desconcido", Toast.LENGTH_SHORT).show()

            }

        }
    }
}