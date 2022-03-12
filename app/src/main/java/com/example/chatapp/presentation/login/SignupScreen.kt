package com.example.chatapp.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chatapp.R
import com.example.chatapp.core.util.Screen

val signupName = mutableStateOf("")
val signupEmail = mutableStateOf("")
val signupPassword = mutableStateOf("")

@Composable
fun SignupScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            BackButton(R.drawable.ic_round_arrow_back, null) {}
            Spacer(modifier = Modifier.height(32.dp))
            TitleSection("Welcome", "Lets get started by creating your account with email")
        }
        SignupSection("Username", "Email address", "Password")
        Column(verticalArrangement = Arrangement.Bottom){
            ContinueButtonSection("Sign up", R.drawable.ic_round_arrow_forward, null) {
                navController.navigate(Screen.HomeScreen.route)
            }
            Spacer(modifier = Modifier.height(20.dp))
            RedirectSection("Login") {
                navController.navigate(Screen.LoginScreen.route)
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}



@Composable
fun SignupSection(
    hintName: String,
    hintEmail: String,
    hintPassword: String
) {
    Column{
        AuthTextField(signupName.value, { signupName.value = it }, hintName)
        Spacer(modifier = Modifier.height(12.dp))
        AuthTextField(signupEmail.value, { signupEmail.value = it }, hintEmail)
        Spacer(modifier = Modifier.height(12.dp))
        AuthTextField(signupPassword.value, { signupPassword.value = it }, hintPassword)
    }
}
