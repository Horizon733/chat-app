package com.example.chatapp

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp.core.presentation.components.ChatItem
import com.example.chatapp.core.presentation.components.TopBar
import com.example.chatapp.ui.theme.ChatappTheme
import com.example.chatapp.utils.DummyDatas.Companion.dummyChats

@Composable
fun MainScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.primary)) {

        TopBar(
            title = stringResource(id = R.string.home_screen_title),
            starIcon = Icons.Outlined.Menu,
            endIcon = Icons.Outlined.Search,
            starIconDescription = "menu",
            endIconDescription = "search button"
        )
        LazyColumn(modifier = Modifier
            .background(Color.White, RoundedCornerShape(topStart = 42.dp, topEnd = 42.dp))
            .weight(1f)) {
            items(dummyChats) { chat ->
                Spacer(modifier = Modifier.height(8.dp))
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

//@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun Preview() {
    ChatappTheme {
        MainScreen()
    }
}