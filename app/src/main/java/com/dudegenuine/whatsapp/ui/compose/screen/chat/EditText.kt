package com.dudegenuine.whatsapp.ui.compose.screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun EditText(modifier: Modifier = Modifier, onMessageSend: (String) -> Unit) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val scrollState = rememberScrollState()

    Box(modifier = modifier.background(color = MaterialTheme.colors.primary)) {
        Row(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
            TextField(
                value = textState.value,
                modifier = Modifier.weight(1f, true),
                onValueChange = {
                    textState.value = it
                })
            Spacer(modifier = Modifier.requiredSize(12.dp))

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