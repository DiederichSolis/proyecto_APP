package com.diederich.ecommerceappmvvm.presentation.screens.roles

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.diederich.ecommerceappmvvm.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController){
    
    Scaffold {paddingValues ->
        RolesContent(paddingValues)
    }
    
}