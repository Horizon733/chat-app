package com.example.chatapp.domain.models

data class UserMessage(
    val id: String,
    val sender: String,
    val text_message: String,
    val timestamp: String,
    val is_seen: Boolean = false
)


