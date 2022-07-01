package com.dudegenuine.whatsapp.ui.compose.screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dudegenuine.whatsapp.data.remote.model.Conversation
import com.dudegenuine.whatsapp.ui.theme.WhatsAppOutgoingMsg

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun ChatsScrollView(chat: List<Conversation>, paddingValues: PaddingValues) {
    LazyColumn(
        Modifier.padding(10.dp),
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
    Column(
        modifier = Modifier.fillMaxWidth()) {

        Column(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .clip(RoundedCornerShape(10.dp))
                .background(WhatsAppOutgoingMsg)
                .padding(5.dp)) {
            Text(
                text = chat.chat,
                fontSize = 15.sp
            )
            Text(
                text = "17.00",
                fontSize = 10.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
@Composable
private fun SetupRecipientChat(chat: Conversation) {
    Column(
        modifier = Modifier.fillMaxWidth()){
        Column(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
                .padding(5.dp)
                .align(Alignment.End)) {
            Text(
                text = chat.chat,
                color = Color.Black,
                fontSize = 15.sp
            )
            Text(
                text = "17.30",
                color = Color.LightGray,
                fontSize = 10.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

