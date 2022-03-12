package com.example.chatapp.models

data class Chat(
    val userName: String,
    val lastMessage: String,
    val unreadMessageCont: Int,
    val profile: String,
    val lastMessageTime: String
)
