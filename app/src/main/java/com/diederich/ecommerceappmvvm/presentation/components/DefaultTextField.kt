package com.diederich.ecommerceappmvvm.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.diederich.ecommerceappmvvm.presentation.ui.theme.loginback2

//creamos un file para la reutilizacion de codigo
@Composable
fun DefaultTextfield(
    modifier: Modifier,
    value:String,
    onValueChange: (value:String) -> Unit,
    label:String,
    icon: ImageVector,
keyboardType: KeyboardType= KeyboardType.Text,
    hideText: Boolean=false

){
    OutlinedTextField(  modifier = modifier
        .fillMaxWidth(),
        value = value,
        onValueChange = { text ->
            onValueChange(text)
                        },
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(imageVector = icon ,
                contentDescription = "",
                tint = loginback2
            )
        },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
       keyboardOptions = KeyboardOptions(keyboardType=keyboardType),
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None //es pare verificar si desea que se oculte los caracteres
    )


}