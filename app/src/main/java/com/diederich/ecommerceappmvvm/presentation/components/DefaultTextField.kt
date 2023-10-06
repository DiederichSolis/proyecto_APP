package com.diederich.ecommerceappmvvm.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import com.diederich.ecommerceappmvvm.presentation.ui.theme.loginback2

//creamos un file para la reutilizacion de codigo
@Composable
fun DefaultTextfield(
    modifier: Modifier,
    value:String,
    onValueChange: (value:String) -> Unit,
    label:String,
    icon: ImageVector,
keyboardType: KeyboardType= KeyboardType.Text
){
    OutlinedTextField(  modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange = { text ->
            onValueChange(text)
                        },
        label = {
            Text(text = "Correo electronico")
        },
        leadingIcon = {
            Icon(imageVector = icon ,
                contentDescription = "",
                tint = loginback2
            )
        },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
       keyboardOptions = KeyboardOptions(keyboardType=keyboardType)
    )


}