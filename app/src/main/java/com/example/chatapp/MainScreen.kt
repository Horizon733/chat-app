package com.example.chatapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chatapp.core.presentation.components.ChatItem
import com.example.chatapp.core.presentation.components.TopBar
import com.example.chatapp.core.util.Screen
import com.example.chatapp.presentation.login.VerticalSpacer
import com.example.chatapp.utils.DummyDatas.Companion.dummyChats

@Composable
fun MainScreen(
    navController: NavController
) {
    ChangeStatusBarColor(color = colors.primary)
    Column(modifier = Modifier
        .fillMaxSize()
        .background(colors.primary)) {

        TopBar(
            title = stringResource(id = R.string.home_screen_title),
            startIcon = Icons.Outlined.Menu,
            endIcon = Icons.Outlined.Search,
            startIconDescription = "menu",
            endIconDescription = "search button",
            onStartIconClick = { navController.navigate(Screen.LoginScreen.route)}
        )
        LazyColumn(modifier = Modifier
            .background(Color.White, RoundedCornerShape(topStart = 42.dp, topEnd = 42.dp))
            .weight(1f)) {
            items(dummyChats) { chat ->
                VerticalSpacer(8.dp)
                ChatItem(
                    chat.userName,
                    chat.lastMessage,
                    chat.unreadMessageCont,
                    chat.profile,
                    chat.lastMessageTime
                )
            }
        }
    }
}