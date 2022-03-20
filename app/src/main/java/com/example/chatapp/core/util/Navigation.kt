package com.example.chatapp.core.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chatapp.presentation.chatscreen.ChatScreen
import com.example.chatapp.presentation.login.LoginScreen
import com.example.chatapp.presentation.mainscreen.MainScreen
import com.example.chatapp.presentation.registration.SignupScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            MainScreen(navController)
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.SignupScreen.route) {
            SignupScreen { navController.popBackStack() }
        }
        composable(
            route = Screen.ChatScreen.route + "/{name}"
        ) {
            ChatScreen(onBackClicked = { navController.popBackStack() }, it.arguments?.getString("name")?: "")
        }
    }
}