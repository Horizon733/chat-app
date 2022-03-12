package com.example.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.core.util.Navigation
import com.example.chatapp.presentation.login.LoginScreen
import com.example.chatapp.presentation.registration.SignupScreen
import com.example.chatapp.ui.theme.ChatappTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatappTheme {
                val navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}

@Composable
fun ChangeStatusBarColor(color: Color) {
    rememberSystemUiController().setStatusBarColor(color)
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChatappTheme {
        Greeting("Android")
    }
}