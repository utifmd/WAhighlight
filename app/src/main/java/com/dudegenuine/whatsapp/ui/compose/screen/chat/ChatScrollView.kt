package com.dudegenuine.whatsapp.ui.compose.screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun ChatsScrollView(chat: List<Conversation>) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight().padding(10.dp).padding(bottom = 40.dp)) { /*.background(color = colorLightGreen())*/
        items(chat){
            if (it.id == 2) {
                SetupRecipientChat(it)
            } else {
                SetupMyChat(it)
            }
        }
    }
    //Spacer(modifier = Modifier.padding(8.dp))
}

@Composable
private fun SetupMyChat(chat: Conversation) {
    Surface(
        color = Color(38, 82, 72),
        modifier = Modifier.fillMaxWidth().padding(80.dp, end = 10.dp),
        shape = RoundedCornerShape(8.dp)) {
        Row(modifier = Modifier.padding(all = 10.dp)) {
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(
                    text = chat.chat,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun SetupRecipientChat(chat: Conversation) {
    Surface(
        color = Color(62, 61, 64),
        modifier = Modifier.fillMaxWidth().padding(10.dp, end = 80.dp),
        shape = RoundedCornerShape(8.dp)) {
        Row(modifier = Modifier.padding(10.dp)) {
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(
                    text = chat.chat,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}