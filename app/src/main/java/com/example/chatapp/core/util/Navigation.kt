package com.example.chatapp.core.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chatapp.MainScreen
import com.example.chatapp.presentation.login.LoginScreen
import com.example.chatapp.presentation.login.SignupScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SignupScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            MainScreen(navController)
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.SignupScreen.route) {
            SignupScreen(navController)
        }
    }
}