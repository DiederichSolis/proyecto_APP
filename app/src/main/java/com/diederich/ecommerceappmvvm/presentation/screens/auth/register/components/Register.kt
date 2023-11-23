package com.diederich.ecommerceappmvvm.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.diederich.ecommerceappmvvm.domain.util.Resource
import com.diederich.ecommerceappmvvm.presentation.components.ProgressBar
import com.diederich.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.diederich.ecommerceappmvvm.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register (navController: NavHostController, vm: RegisterViewModel = hiltViewModel()){

    when(val response = vm.registerResponse){
        Resource.Loading -> { ProgressBar() }
        is Resource.Success -> {
            LaunchedEffect(Unit){
                navController.navigate(route = AuthScreen.Home.route)
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current,response.message,Toast.LENGTH_SHORT).show()
        }
        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current,"Error desconocido",Toast.LENGTH_SHORT).show()

            }
        }
    }
}
