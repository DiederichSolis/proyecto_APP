package com.diederich.ecommerceappmvvm.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.diederich.ecommerceappmvvm.R
import com.diederich.ecommerceappmvvm.presentation.components.DefaultButton
import com.diederich.ecommerceappmvvm.presentation.components.DefaultTextfield
import com.diederich.ecommerceappmvvm.presentation.screens.auth.register.RegisterState
import com.diederich.ecommerceappmvvm.presentation.screens.auth.register.RegisterViewModel

@Composable
fun RegisterContent(paddingValues: PaddingValues, vm:RegisterViewModel = hiltViewModel()){

    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage){
        if (vm.errorMessage !=""){
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
        }
    }



    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.registerbackg ),
            contentDescription = "fondo de pantalla de registro",
            contentScale = ContentScale.Crop,
            //  colorFilter = ColorFilter.colorMatrix(
              // ColorMatrix().apply {
                //setToScale(redScale = 0.25f, greenScale = 0.25f, blueScale = 0.255f, alphaScale =0.25f)//practicamente es para difuminar el fondo
             //}
              // )
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            //Image(
       //         modifier  = Modifier
         ////         .width(90.dp)
//                    .padding(top = 20.dp),
              //  painter = painterResource(id = R.drawable.profleicon),
                //contentDescription = "icono de usuario"
            //)

          //  Text(
           //     modifier = Modifier.padding(top = 7.dp),
             //   text = "",
               // fontWeight = FontWeight.Bold,
                //fontSize = 20.sp,
                //color= Color.Black
                //)
            
            Spacer(modifier = Modifier.weight(1f))
            
            Card  (
                modifier =Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp
                ),
                backgroundColor = Color.White.copy(alpha = 0.8f)
            ) {
                Column(modifier = Modifier
                    .padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 30.dp)
                    .verticalScroll(rememberScrollState()))
                {

                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "REGISTRARSE",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                        )

                    DefaultTextfield(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.name,
                        onValueChange ={ vm.onNameInput(it)} ,
                        label = "Nombre",
                        icon = Icons.Default.Person
                    )

                    DefaultTextfield(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lastname,
                        onValueChange ={vm.onLastnameInput(it)} ,
                        label = "Apellido",
                        icon = Icons.Outlined.Person
                    )

                    DefaultTextfield(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange ={vm.onEmailInput(it)} ,
                        label = "Correo Electronico",
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )

                    DefaultTextfield(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.phone,
                        onValueChange ={vm.onPhoneInput(it)} ,
                        label = "Telefono",
                        icon = Icons.Default.Phone,
                        keyboardType = KeyboardType.Number
                    )

                    DefaultTextfield(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange ={vm.onPasswordInput(it)} ,
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )

                    DefaultTextfield(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.confirmPassword,
                        onValueChange ={vm.onConfirmPasswordInput(it)} ,
                        label = "Confirmar Contraseña",
                        icon = Icons.Outlined.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )

                    
                    Spacer(modifier = Modifier.height(15.dp))
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        text = "CONFIRMAR",
                        onClick = { vm.validateForm() })

                }


            }
        }

    }

}