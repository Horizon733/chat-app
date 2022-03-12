package com.example.chatapp.presentation.chatscreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Attachment
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.ChangeStatusBarColor
import com.example.chatapp.presentation.login.VerticalSpacer
import com.example.chatapp.ui.theme.ChatappTheme


data class Chat(
    val message: String,
    val time: String,
    val isOutgoing: Boolean
)

val message = mutableStateOf("")

val chats = mutableStateListOf(
    Chat("Hi", "10:00 pm", true),
    Chat("Hello", "10:00 pm", false),
    Chat("What's up", "10:02 pm", false),
    Chat("I am fine", "10:02 pm", true),
    Chat("How are you doing", "10:06 pm", true),
    Chat("I am good", "10:11 pm", false),
)

const val username = "Gojo Satoru"
const val isOnline = true

@Composable
fun ChatScreen() {
    ChangeStatusBarColor(White)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colors.primary),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        TopBarSection(
            username = username,
            isOnline = isOnline
        ) { }
        ChatSection(Modifier.weight(1f))
        MessageSection()
    }
}

@Composable
fun TopBarSection(
    username: String,
    isOnline: Boolean,
    onBack: () -> Unit
) {
    TopAppBar(
        backgroundColor = White,
        contentColor = Black
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconButton(
                onClick = onBack,
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBackIos,
                    contentDescription = "Back",
                )
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    color = Black,
                    text = username,
                    fontWeight = FontWeight.ExtraBold
                )
                if (isOnline) {
                    Text(
                        text = "Online",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                }
            }

            IconButton(
                onClick = { },
            ) {
                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = "Call",
                )
            }

        }

    }

}

@Composable
fun ChatSection(
    modifier: Modifier = Modifier,

    ) {
    LazyColumn(
        reverseLayout = true,
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = White,
                shape = RoundedCornerShape(
                    bottomStart = 50.dp,
                    bottomEnd = 50.dp
                )

            )
            .padding(16.dp),
    ) {
        items(chats) { chat ->
            MessageItem(
                chat.message,
                chat.time.uppercase(),
                chat.isOutgoing
            )
            VerticalSpacer(8.dp)
        }
    }
}

@Composable
fun MessageSection() {
    Column(
        Modifier
            .background(colors.primary)
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        TextField(
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { addChat() }),
            placeholder = {
                Text(
                    "Message..",
                    color = White
                )

            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colors.background,
                focusedBorderColor = colors.primary,
                textColor = White,
            ),
            value = message.value,
            onValueChange = {
                message.value = it
            },
            shape = RoundedCornerShape(25.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.EmojiEmotions,
                    tint = White,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        chats.add(Chat(message.value, "10:00 PM", true))
                        message.value = ""
                    }
                )

            },
            trailingIcon = {
                Row {
                    Icon(
                        imageVector = Icons.Default.Attachment,
                        tint = White,
                        contentDescription = null,
                        modifier = Modifier
                            .rotate(315f)
                            .clickable {
                            }
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(
                        imageVector = Icons.Default.Send,
                        tint = White,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            addChat()
                        }
                    )
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
        )
    }

}

private fun addChat() {
    chats.add(0, Chat(message.value, "10:00 PM", true))
    message.value = ""
}

@Composable
fun MessageItem(
    messageText: String,
    time: String,
    isOut: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (isOut) Alignment.End else Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .background(
                    if (isOut) colors.primary else Color(0xFFF3F6FA),
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomStart = if (isOut) 16.dp else 0.dp,
                        bottomEnd = if (isOut) 0.dp else 16.dp
                    )
                )
                .padding(
                    top = 8.dp,
                    bottom = 8.dp,
                    start = 16.dp,
                    end = 16.dp
                )
        ) {
            Text(
                text = messageText,
                fontWeight = FontWeight.Bold,
                color = if (isOut) White else DarkGray,
            )
        }

        Text(
            text = time,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            color = Black,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
//@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun Preview() {
    ChatappTheme {
        ChatScreen()
    }
}