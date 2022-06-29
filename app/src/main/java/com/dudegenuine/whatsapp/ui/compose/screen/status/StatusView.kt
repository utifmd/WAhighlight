package com.dudegenuine.whatsapp.ui.compose.screen.status

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import com.dudegenuine.whatsapp.data.local.statusList

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun StatusView() {
    LazyColumn {
        items(statusList){ status ->
            StatusItemView(status)
            Divider()
        }
    }
}