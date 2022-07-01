package com.dudegenuine.whatsapp.ui.compose.screen.chat

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.dudegenuine.whatsapp.data.local.chat
import com.dudegenuine.whatsapp.data.remote.model.User
import com.dudegenuine.whatsapp.ui.theme.WhatsAppChatBg

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun ChatScreenView(user: User, onBackIconClick: () -> Unit) {
    Scaffold(
        bottomBar = { BottomDesign() },
        backgroundColor = WhatsAppChatBg,
        topBar = {
            ChatTopBar(user, onBackIconClick)
        },
        content = { padding ->
            ChatsScrollView(chat.toList(), padding)
        }
    )
}