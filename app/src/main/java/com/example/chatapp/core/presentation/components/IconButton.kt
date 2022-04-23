package com.example.chatapp.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp.ui.theme.ChatappTheme
import com.example.chatapp.ui.theme.Shapes

@Composable
fun IconButton(
    icon: ImageVector,
    description: String? = null,
    onButtonClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(MaterialTheme.colors.secondary, shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = { onButtonClick() }) {
            Icon(
                imageVector = icon,
                contentDescription = description,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun IconButtonPreview() {
    ChatappTheme {
        IconButton(Icons.Outlined.Search)
    }
}