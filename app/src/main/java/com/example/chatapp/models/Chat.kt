package com.example.chatapp.models

import androidx.compose.ui.graphics.painter.Painter

data class Chat(
    val userName: String,
    val lastMessage: String,
    val unreadMessageCont: Int,
    val profile: String,
    val lastMessageTime: String
)
