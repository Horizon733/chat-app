package com.example.chatapp.presentation.login

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp.R
import com.example.chatapp.ui.theme.ChatappTheme

val loginEmail = mutableStateOf("")
val loginPassword = mutableStateOf("")

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //BackButton(R.drawable.ic_round_arrow_back, null, onClick = {})
            TopBarSection("Chat App")
            Spacer(modifier = Modifier.height(12.dp))
            TitleSection("Welcome Back!")
            Vector(id = R.drawable.ic_signup_vector)
        }
        Column(verticalArrangement = Arrangement.Bottom) {
            LoginSection("Username or Email", "Password")
            Spacer(modifier = Modifier.height(12.dp))
            RedirectSection("Don't have an account?","Sign up") {  }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun LoginSection(
    hintEmail: String,
    hintPassword: String
) {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        AuthTextField(loginEmail.value, { loginEmail.value = it }, hintEmail)
        Spacer(modifier = Modifier.height(12.dp))
        AuthTextField(loginPassword.value, { loginPassword.value = it }, hintPassword, isPasswordField = true)
        Spacer(modifier = Modifier.height(12.dp))
        ForgotPasswordSection()
        Spacer(modifier = Modifier.height(12.dp))
        ContinueButtonSection("Login")


    }
}


@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LoginPreview() {
    //TopActionBar()
    ChatappTheme {
        Surface{
            LoginScreen()
        }
    }
}