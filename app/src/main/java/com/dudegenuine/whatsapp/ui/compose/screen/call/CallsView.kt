package com.dudegenuine.whatsapp.ui.compose.screen.call

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dudegenuine.whatsapp.data.local.calls

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun CallsView() {
    LazyColumn {
        items(calls) { call ->
            CallsItem(call)
            Divider()
        }
    }
}