package com.diederich.ecommerceappmvvm.presentation.screens.auth.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RegisterScreen(){

    Scaffold() { paddingValues ->
        Text(
            modifier = Modifier.padding(paddingValues = paddingValues),
            text = "RegisterScreen")
    }
}