package com.example.chatapp.domain.models

data class User(
    val id: String,
    val username: String? = null,
    val email: String? = null,
    val password: String,
    val last_login: String? =null,
    val online: String? = null,
    val contacts: List<String>? = null
)

