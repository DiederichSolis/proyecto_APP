package com.diederich.ecommerceappmvvm.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.diederich.ecommerceappmvvm.presentation.ui.theme.loginback
import com.diederich.ecommerceappmvvm.presentation.ui.theme.loginback2


@Composable
fun DefaultButton(
    modifier: Modifier,
    text:String,
    onClick:() -> Unit,
    color: Color = loginback
){
    Button(
        modifier = modifier,
        onClick = {onClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = color)
    ) {
        Text(text = text)
        
    }
}