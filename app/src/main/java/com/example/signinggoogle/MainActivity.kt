package com.example.signinggoogle


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold

import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.signinggoogle.ui.theme.SigningGoogleTheme
import com.example.signinggoogle.view.LoginScreen
import com.example.signinggoogle.view.UserProfileScreen



class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SigningGoogleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController=navController, startDestination = "Login"
                    ){
                        composable("Login") {LoginScreen(innerPadding,navController)}
                        composable ("UserProfile"){ UserProfileScreen(navController,innerPadding) }

                    }
                }
            }
        }
    }
}

