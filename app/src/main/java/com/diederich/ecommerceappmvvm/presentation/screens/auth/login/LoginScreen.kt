package com.diederich.ecommerceappmvvm.presentation.screens.auth.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.diederich.ecommerceappmvvm.presentation.screens.auth.login.components.LoginContent
import com.diederich.ecommerceappmvvm.presentation.ui.theme.EcommerceAppMVVMTheme


@Composable
fun LoginScreeen(){
    Scaffold(){
            paddingValues ->
        LoginContent(paddingValues)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreeenPreview() {
    EcommerceAppMVVMTheme {
LoginScreeen()
    }
}