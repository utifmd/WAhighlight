package com.dudegenuine.whatsapp.ui.compose.screen.chat

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.dudegenuine.whatsapp.data.local.chat
import com.dudegenuine.whatsapp.domain.model.User

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun ChatScreenView(user: User, onBackIconClick: () -> Unit, onMessageSend: (String) -> Unit) {
    Scaffold(
        bottomBar = { EditText(onMessageSend = onMessageSend) },
        topBar = {
            ChatTopBar(user, onBackIconClick)
        },
        content = {
            ChatsScrollView(chat.toList())
        }
    )
}