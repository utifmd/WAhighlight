package com.dudegenuine.whatsapp.ui.compose.screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun EditText(modifier: Modifier = Modifier, onMessageSend: (String) -> Unit) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Box(modifier = modifier.background(color = MaterialTheme.colors.primary)) {
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            TextField(
                value = textState.value,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.onPrimary
                ),
                modifier = Modifier.weight(8.5f, true),
                onValueChange = {
                    textState.value = it
                })
            Spacer(modifier = Modifier.requiredSize(12.dp))

            IconButton(modifier = Modifier.weight(1.5f, true), content = {
                Icon(Icons.Default.Send, tint = MaterialTheme.colors.onPrimary, contentDescription = null)
            }, onClick = {
                onMessageSend(textState.value.text)
                scope.launch{ scrollState.animateScrollTo(0) }
            })
            /*ImageLoader(
                imageUrl = R.drawable.ic_send,
                modifier = Modifier.weight(0.05f, true),
                onClick = {

                    onMessageSend(textState.value.text)
                    scrollState.smoothScrollTo(0f)
                })*/
        }
    }
}