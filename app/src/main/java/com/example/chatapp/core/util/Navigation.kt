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

const val chatScreenArg = "name"

@Composable
fun Navigation(navController: NavHostController) {

    navController.apply {
        NavHost(
            navController = this,
            startDestination = LoginScreen.route
        ) {

            composable(route = LoginScreen.route) {
                LoginScreen { navigateToAndClearBackStack(it) }
            }

            composable(route = SignupScreen.route) {
                SignupScreen { navigateToAndClearBackStack(LoginScreen.route) }
            }

            composable(route = HomeScreen.route) {
                MainScreen(navController)
            }

            composable(route = chatScreenRouteFetch(chatScreenArg)) {
                ChatScreen(
                    onBackClicked = { popBackStack() },
                    username = it.arguments?.getString(chatScreenArg) ?: ""
                )
            }
        }
    }
}

fun NavController.navigateToAndClearBackStack(toRoute: String) {
    navigate(toRoute) {
        popUpTo(currentDestination!!.route!!) {
            inclusive = true
        }
    }
}

fun NavController.navigateToChatScreen(name: String) {
    navigate(ChatScreen.route + "/$name")
}

fun chatScreenRouteFetch(arg: String) = ChatScreen.route + "/{$arg}"
