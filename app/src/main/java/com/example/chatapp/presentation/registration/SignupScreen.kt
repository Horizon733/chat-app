package com.example.chatapp.presentation.registration

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp.ChangeStatusBarColor
import com.example.chatapp.R
import com.example.chatapp.presentation.login.*
import com.example.chatapp.ui.theme.ChatappTheme

val signupName = mutableStateOf("")
val signupEmail = mutableStateOf("")
val signupPassword = mutableStateOf("")

@Composable
fun SignupScreen() {
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
            //BackButton(R.drawable.ic_round_arrow_back, null) {}
            TopBarSection("Chat App")
            VerticalSpacer()
            TitleSection("Register")
            Vector(id = R.drawable.ic_signup_vector)
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            SignupSection("Username", "Email address", "Password")
            VerticalSpacer()
            RedirectSection("Already have an account?", "Login") { /*todo navigation*/ }
            VerticalSpacer()
        }
    }
}


@Composable
fun SignupSection(
    hintName: String,
    hintEmail: String,
    hintPassword: String
) {
    Column(
        Modifier
            .padding(24.dp)
            .scrollable(ScrollableState { .25f }, Orientation.Vertical)
    ) {
        AuthTextField(signupName.value, { signupName.value = it }, hintName)
        Spacer(modifier = Modifier.height(12.dp))
        AuthTextField(signupEmail.value, { signupEmail.value = it }, hintEmail)
        Spacer(modifier = Modifier.height(12.dp))
        AuthTextField(
            signupPassword.value,
            { signupPassword.value = it },
            hintPassword,
            isPasswordField = true
        )
        Spacer(modifier = Modifier.height(12.dp))
        ContinueButtonSection("Sign up")
    }
}

//@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SignupPreview() {
    ChatappTheme {
        Surface {
            SignupScreen()
        }
    }
}
