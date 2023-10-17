package com.diederich.ecommerceappmvvm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.diederich.ecommerceappmvvm.R
import com.diederich.ecommerceappmvvm.presentation.navigation.graph.RootNavGraph
import com.diederich.ecommerceappmvvm.presentation.screens.auth.login.LoginScreeen
import com.diederich.ecommerceappmvvm.presentation.ui.theme.EcommerceAppMVVMTheme
import com.diederich.ecommerceappmvvm.presentation.ui.theme.loginback1
import com.diederich.ecommerceappmvvm.presentation.ui.theme.loginback2
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private  lateinit var navCotroller: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcommerceAppMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    navCotroller = rememberNavController()
                    RootNavGraph(navController = navCotroller)

                }
            }
        }
    }
}




