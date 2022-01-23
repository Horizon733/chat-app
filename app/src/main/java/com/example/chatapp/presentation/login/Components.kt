package com.example.chatapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val radius = 14.dp
val height = 50.dp
val titleTextSize = 40.sp
const val topBarRadiusPercent = 50

@Composable
fun Vector(id: Int){
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        Modifier.fillMaxWidth()
    )
}

@Composable
fun TopBarSection(
    text: String
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(
                White,
                RoundedCornerShape(
                    bottomStartPercent = topBarRadiusPercent,
                    bottomEndPercent = topBarRadiusPercent
                )
            )
            .height(height * 2)
            .fillMaxWidth()

    ){
        Text(
            text, color = MaterialTheme.colors.primary,
            fontSize = titleTextSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TitleSection(
    title: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(start = 4.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = titleTextSize,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun ForgotPasswordSection() {
    Column(Modifier.fillMaxWidth())
    {
        TextButton(
            onClick = {},
            shape = RoundedCornerShape(radius),
            modifier = Modifier
                .height(height)
                .align(Alignment.End)
        ) {
            Text(
                text = "Forgot password?",
                color = White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
            )
        }
    }

}

@Composable
fun RedirectSection(
    text:String,
    linkText: String,
    onClick: () -> Unit
) {
    Column(
        Modifier.fillMaxWidth()
    ) {
        TextButton(
            onClick = onClick,
            shape = RoundedCornerShape(radius),
            modifier = Modifier
                .height(height)
                .align(Alignment.CenterHorizontally)
        ) {

            Text(
                text = text,
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal

            )
            Spacer(Modifier.width(5.dp))
            Text(
                text = linkText,
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}



@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hintTitle: String,
    isPasswordField: Boolean = false
) {
    var passwordVisibility by remember { mutableStateOf(!isPasswordField) }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(radius),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = White,
            focusedBorderColor = White
        ),
        label = {
            Text(text = hintTitle, color = Gray)
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            if(isPasswordField) {
                IconButton(
                    onClick = { passwordVisibility = !passwordVisibility }
                ) {
                    Icon(
                        imageVector = if (passwordVisibility)
                            Icons.Filled.Visibility
                        else
                            Icons.Filled.VisibilityOff,
                        contentDescription = null,
                        tint = Gray
                    )

                }
            }
        }
        ,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ContinueButtonSection(
    text: String = ""
) {
    OutlinedButton(
        modifier = Modifier
            .height(height)
            .fillMaxWidth(),
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = White),
        shape = RoundedCornerShape(radius),
        elevation = ButtonDefaults.elevation(10.dp),
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colors.primary
        )
    }
}




