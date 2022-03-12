package com.example.chatapp.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp.R

val loginEmail = mutableStateOf("")
val loginPassword = mutableStateOf("")

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            BackButton(R.drawable.ic_round_arrow_back, null, onClick = {})
            Spacer(modifier = Modifier.height(32.dp))
            TitleSection("Welcome Back", "Login to your account using email")
        }
        LoginSection("Username or Email", "Password")
        Column(verticalArrangement = Arrangement.Bottom) {
            ContinueButtonSection("Login", R.drawable.ic_round_arrow_forward, null)
            Spacer(modifier = Modifier.height(20.dp))
            RedirectSection("Sign up") {}
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun LoginSection(
    hintEmail: String,
    hintPassword: String
) {
    Column {
        AuthTextField(loginEmail.value, { loginEmail.value = it }, hintEmail)
        Spacer(modifier = Modifier.height(12.dp))
        AuthTextField(loginPassword.value, { loginPassword.value = it }, hintPassword)
        Spacer(modifier = Modifier.height(12.dp))
        ForgotPasswordSection()
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    //TopActionBar()
    LoginScreen()
}