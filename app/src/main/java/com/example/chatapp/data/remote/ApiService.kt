package com.example.chatapp.data.remote

import com.example.chatapp.domain.models.User
import com.example.chatapp.domain.models.UserMessage
import retrofit2.http.DELETE
import retrofit2.http.PATCH
import retrofit2.http.POST

interface ApiService {

    @POST("register")
    fun registerUser(user:User): String

    @POST("login")
    fun login(user: User): String

    @PATCH("users/update-user")
    fun updateUser(user: User): String

    @DELETE("users/delete")
    fun deleteUser(user: User): String

    @POST("messages/send-message")
    fun sendMessage(userMessage: UserMessage): String

    @PATCH("messages/update-seen")
    fun updateSeen(userMessage: UserMessage): String

    @POST("messages/get-messages")
    fun getMessages(userMessage: UserMessage)


}