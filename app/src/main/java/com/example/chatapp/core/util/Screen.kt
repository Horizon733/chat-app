package com.example.chatapp.core.util

const val chatSenderName = "senderName"
sealed class Screen(private val routeName: String, private val argsList: List<String> = listOf()) {
    object HomeScreen: Screen("home_screen")
    object LoginScreen: Screen("login_screen")
    object SignupScreen: Screen("signup_screen")
    object ChatScreen: Screen("chat_screen", listOf(chatSenderName))

    val route = buildString {
            append(routeName)
            argsList.forEach { append("/{$it}") }
        }

    fun navigateWithArgs(argsList: List<String> = listOf()) = buildString {
        append(routeName)
        argsList.forEach { append("/$it") }
    }
}