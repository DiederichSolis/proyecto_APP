package com.diederich.ecommerceappmvvm

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diederich.ecommerceappmvvm.ui.theme.EcommerceAppMVVMTheme
import com.diederich.ecommerceappmvvm.ui.theme.loginback
import com.diederich.ecommerceappmvvm.ui.theme.loginback1
import com.diederich.ecommerceappmvvm.ui.theme.loginback2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcommerceAppMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  LoginContent()
                }
            }
        }
    }
}


@Composable
fun LoginContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.backimage),
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
        .height(320.dp),
        shape = RoundedCornerShape(
            topEnd = 40.dp,
            topStart = 40.dp),
        backgroundColor = loginback1 )
    {
        //elementos del login
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 20.dp),
                text = "BIENVENIDO",
            fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
            TextField(  modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
            label = {
                Text(text = "Correo electronico")
            }
            )
            TextField(  modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
            label = {
                Text(text = "Contraseña")
            }
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {  }) {
                Text(text = "LOGIN")
            }
            Row() {
              Text(text = "No tienes cuenta ?")
                Text(text = "Registrate",
                    fontWeight = FontWeight.Bold,
                color = loginback2)
            }
        }

    }


}

      
    }

}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    EcommerceAppMVVMTheme {
        LoginContent()
    }
}