package com.dudegenuine.whatsapp.ui.compose.screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dudegenuine.whatsapp.domain.model.Conversation
import com.dudegenuine.whatsapp.ui.theme.ColorPrimaryDark
import com.dudegenuine.whatsapp.ui.theme.ColorPrimaryLight

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun ChatsScrollView(chat: List<Conversation>, paddingValues: PaddingValues) {
    LazyColumn(
        contentPadding = paddingValues,
        verticalArrangement = Arrangement.spacedBy(8.dp)) { /*.padding(10.dp).padding(bottom = 40.dp)*/
        items(chat){
            if (it.id == 2) {
                SetupRecipientChat(it)
            } else {
                SetupMyChat(it)
            }
        }
    }
}

@Composable
private fun SetupMyChat(chat: Conversation) {
    Surface(
        color = MaterialTheme.colors.primary.copy(alpha = 0.1f),
        modifier = Modifier.fillMaxWidth().padding(80.dp, end = 10.dp),
        shape = RoundedCornerShape(8.dp)) {
        Row(modifier = Modifier.padding(all = 10.dp)) {
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(
                    text = chat.chat,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
private fun SetupRecipientChat(chat: Conversation) {
    Surface(
        color = MaterialTheme.colors.primary.copy(0.5f),
        modifier = Modifier.fillMaxWidth().padding(10.dp, end = 80.dp),
        shape = RoundedCornerShape(8.dp)) {
        Row(modifier = Modifier.padding(10.dp)) {
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(chat.chat,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}