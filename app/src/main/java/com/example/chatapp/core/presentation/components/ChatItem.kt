package com.example.chatapp.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.chatapp.ui.theme.ChatappTheme

@Composable
fun ChatItem(
    userName: String,
    lastMessage: String,
    unreadMessageCont: Int,
    profile: String,
    lastMessageTime: String,
    onClick: (String) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(60.dp)
            .clickable { onClick(userName) },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = rememberImagePainter(profile),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = userName, color = MaterialTheme.colors.primary, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = lastMessage, color = MaterialTheme.colors.secondary.copy(alpha = .6f), fontSize = 14.sp)
        }
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = lastMessageTime, color = MaterialTheme.colors.secondary.copy(alpha = .6f), fontSize = 12.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(MaterialTheme.colors.primary, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = unreadMessageCont.toString(), color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ChatItemPreview() {
    ChatappTheme {
        ChatItem(
            "Biren",
            "Hii",
            2,
            "okay",
            ""
        )
    }
}