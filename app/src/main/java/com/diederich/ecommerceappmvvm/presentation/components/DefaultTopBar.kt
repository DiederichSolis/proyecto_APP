package com.diederich.ecommerceappmvvm.presentation.components

import android.icu.text.CaseMap.Title
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean = false,
    navController: NavHostController?=null

){
    TopAppBar(
        title = {
            Text(
                text = "Registro",
                fontSize = 19.sp
            )
        },
        backgroundColor = Color.LightGray,
        navigationIcon = {
            if (upAvailable) {
                IconButton(onClick = { navController?.popBackStack()  }) { //funcion para regresar a pantalla anterior
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.Black
                    )

                }
            }

        }
    )
}