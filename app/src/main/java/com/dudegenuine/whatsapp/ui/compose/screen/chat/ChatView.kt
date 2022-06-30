package com.dudegenuine.whatsapp.ui.compose.screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dudegenuine.whatsapp.data.local.chatsList
import com.dudegenuine.whatsapp.domain.model.User

/**
 * Thu, 30 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun ChatView(onDetailView: (User) -> Unit) {
    LazyColumn {
        items(chatsList){ chat ->
            ChatsItemView(chat = chat, onDetailView = onDetailView)
            Divider()
        }
    }
}