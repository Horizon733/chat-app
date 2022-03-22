package com.example.chatapp.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.example.chatapp.ChangeStatusBarColor
import com.example.chatapp.R
import com.example.chatapp.core.util.Screen.HomeScreen
import com.example.chatapp.core.util.Screen.SignupScreen

val loginEmail = mutableStateOf("")
val loginPassword = mutableStateOf("")

@Composable
fun LoginScreen(
    navigateTo: (String) -> Unit
) {
    ChangeStatusBarColor(White)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //BackButton(R.drawable.ic_round_arrow_back, null, onClick = {})
            TopBarSection("Chat App")
            VerticalSpacer()
            TitleSection("Welcome Back!")
            Vector(id = R.drawable.ic_signup_vector)
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            LoginSection("Username or Email", "Password", navigateTo)
            VerticalSpacer()
            RedirectSection("Don't have an account?", "Sign up") {
                navigateTo(SignupScreen.route)
            }
            VerticalSpacer()
        }
    }
}

@Composable
fun LoginSection(
    hintEmail: String,
    hintPassword: String,
    navigateTo: (String) -> Unit
) {
    Column(
        Modifier
            .padding(24.dp)
            .scrollable(ScrollableState { .25f }, Orientation.Vertical)
    ) {
        AuthTextField(loginEmail.value, { loginEmail.value = it }, hintEmail)
        Spacer(modifier = Modifier.height(12.dp))
        AuthTextField(
            loginPassword.value,
            { loginPassword.value = it },
            hintPassword,
            isPasswordField = true
        )
        Spacer(modifier = Modifier.height(12.dp))
        ForgotPasswordSection()
        Spacer(modifier = Modifier.height(12.dp))
        ContinueButtonSection("Login") {
            navigateTo(HomeScreen.route)
        }
    }
}
