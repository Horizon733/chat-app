package com.example.chatapp.core.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chatapp.core.util.Screen.*
import com.example.chatapp.presentation.chatscreen.ChatScreen
import com.example.chatapp.presentation.login.LoginScreen
import com.example.chatapp.presentation.mainscreen.MainScreen
import com.example.chatapp.presentation.registration.SignupScreen


@Composable
fun Navigation(navController: NavHostController) {

    navController.apply {
        NavHost(this, LoginScreen.route) {

            composable(LoginScreen.route) { LoginScreen { navigateTo(it, true) } }

            composable(SignupScreen.route) { SignupScreen { navigateTo(LoginScreen, true) } }

            composable(HomeScreen.route) { MainScreen { screen, args -> navigateTo(screen, argsList = args) } }

            composable(ChatScreen.route) {
                ChatScreen(
                    onBackClicked = { popBackStack() },
                    username = it.arguments?.getString(chatSenderName) ?: ""
                )
            }
        }
    }
}

fun NavController.navigateTo(toRoute: Screen, isBackStackCleared: Boolean = false, argsList: List<String> = listOf()) {
    navigate(toRoute.navigateWithArgs(argsList)) {
        if (isBackStackCleared)
            popUpTo(currentDestination!!.route!!) {
            inclusive = true
        }
    }
}

