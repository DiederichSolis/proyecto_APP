package com.diederich.ecommerceappmvvm.presentation.screens.auth.login.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.diederich.ecommerceappmvvm.R
import com.diederich.ecommerceappmvvm.presentation.components.DefaultButton
import com.diederich.ecommerceappmvvm.presentation.components.DefaultTextfield
import com.diederich.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.diederich.ecommerceappmvvm.presentation.screens.auth.login.LoginViewModel
import com.diederich.ecommerceappmvvm.presentation.ui.theme.loginback1
import com.diederich.ecommerceappmvvm.presentation.ui.theme.loginback2


@Composable
fun LoginContent(navController: NavHostController,paddingValues: PaddingValues, vm: LoginViewModel = hiltViewModel()) {



    val state = vm.state
    val context = LocalContext.current



    LaunchedEffect(key1 = vm.errorMessage){
        if (vm.errorMessage !=""){
           Toast.makeText(context, vm.errorMessage,Toast.LENGTH_LONG).show()
            vm.errorMessage=""
        }
    }

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.loginback),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            //   colorFilter = ColorFilter.colorMatrix(
            //   ColorMatrix().apply {
            //     setToScale(redScale = 0.5f, greenScale = 0.5f, blueScale = 0.5f, alphaScale = 0.5f)//practicamente es para difuminar el fondo
            // }
            //)

        ) //Quita los espacios sobrante de la imagen
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Card(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp),
                backgroundColor = loginback1.copy(alpha = 0.5f) )
            {
                //elementos del login
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, end = 30.dp, start = 30.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "BIENVENIDO",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    DefaultTextfield(
                        modifier =Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = {
                            vm.onEmailInput(it)
                        },
                        label = "Correo electronico" ,
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )

                    DefaultTextfield(
                        modifier =Modifier.fillMaxWidth(),
                        value = state.password ,
                        onValueChange = {
                                     vm.onPasswordInput(it)
                        },
                        label = "Contraseña" ,
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )

                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        text = " LISTO",
                        onClick = { vm.login() }
                    )

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 1.dp),//separaciones
                        horizontalArrangement = Arrangement.Center) {
                        Text(text = "No tienes cuenta?")
                        Text(
                            modifier = Modifier.clickable { navController.navigate(route = AuthScreen.Register.route) },
                            text = " Regístrate",
                            fontWeight = FontWeight.Bold,
                            color = loginback2
                        )
                    }
                }

            }


        }


    }

}
