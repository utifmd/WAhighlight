package com.dudegenuine.whatsapp.ui.compose.screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dudegenuine.whatsapp.domain.model.Chat
import com.dudegenuine.whatsapp.domain.model.User
import com.dudegenuine.whatsapp.ui.compose.component.ImageView

/**
 * Thu, 30 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun ChatsItemView(chat: Chat, onDetailView: (User) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 4.dp)
            .clickable {
                onDetailView(
                    User(
                        id = 2,
                        chat.name,
                        chat.url
                    )
                )
            }) {
        Row(modifier = Modifier.padding(10.dp)) {
            Surface(shape = CircleShape, modifier = Modifier.size(40.dp)) {
                ImageView(url = chat.url)
            }
            Spacer(modifier = Modifier.requiredSize(12.dp))
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(chat.name)
                Spacer(modifier = Modifier.requiredSize(2.dp))
                UserChat(chat)
            }
            Column(modifier = Modifier.weight(1.0f, true), horizontalAlignment = Alignment.End) {
                MessageTime(chat)
                Spacer(modifier = Modifier.requiredSize(2.dp))
                UnreadCount(chat)
            }
        }
    }
}

@Composable
private fun UserChat(chat: Chat) {

    Text(
        text = chat.chat,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Gray
        ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}


@Composable
private fun MessageTime(chat: Chat) {

    Text(
        text = chat.time,
        style = TextStyle(
            fontSize = 12.sp,
            color = MaterialTheme.colors.primarySurface
        )
    )
}

@Composable
private fun UnreadCount(chat: Chat) {

    if (chat.unreadCount != "0") {
        SetupUnreadCount(chat.unreadCount)
    }
}

@Composable
private fun SetupUnreadCount(count: String) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .requiredSize(20.dp)
                .background(shape = CircleShape, color = MaterialTheme.colors.primarySurface),
            contentAlignment = Alignment.Center) {
            Text(
                text = count,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = MaterialTheme.colors.onPrimary
                )
            )
        }
    }
}