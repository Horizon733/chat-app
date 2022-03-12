package com.example.chatapp.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.core.util.Screen

@Composable
fun TitleSection(
    title: String,
    description: String
) {
    Column(
        modifier = Modifier.padding(start = 4.dp)
    ) {
        Text(
            text = title,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(text = description, fontSize = 16.sp)
    }
}

@Composable
fun BackButton(
    icon: Int,
    iconDescription: String?,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.White, CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = iconDescription
        )
    }
}

@Composable
fun ForgotPasswordSection(){
    Column(
        Modifier.height(40.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Forgot password?",
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.End)
        )
    }

}

@Composable
fun RedirectSection(
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Blue,
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}

@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hintTitle: String,
) {
    Column{
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = {
                Text(text = hintTitle, color = Color.Gray)
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun ContinueButtonSection(
    text: String = "",
    icon: Int,
    iconDescription: String? = null,
    onButtonClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )
        Surface(
            color = Color.Blue,
            shape = CircleShape,
            elevation = 8.dp
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clickable(onClick = onButtonClick),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = iconDescription,
                    tint = Color.White
                )
            }
        }
    }
}
