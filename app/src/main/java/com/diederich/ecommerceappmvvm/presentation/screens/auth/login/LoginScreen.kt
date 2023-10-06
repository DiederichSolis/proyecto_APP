package com.diederich.ecommerceappmvvm.presentation.screens.auth.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.diederich.ecommerceappmvvm.presentation.screens.auth.login.components.LoginContent
import com.diederich.ecommerceappmvvm.presentation.ui.theme.EcommerceAppMVVMTheme


@Composable
fun LoginScreeen(navController: NavHostController){
    Scaffold(){
            paddingValues ->
        LoginContent(navController = navController,paddingValues)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreeenPreview() {
    EcommerceAppMVVMTheme {
LoginScreeen(rememberNavController())
    }
}