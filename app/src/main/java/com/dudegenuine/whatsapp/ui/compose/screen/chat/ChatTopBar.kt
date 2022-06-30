package com.dudegenuine.whatsapp.ui.compose.screen.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dudegenuine.whatsapp.domain.model.User
import com.dudegenuine.whatsapp.ui.compose.component.ImageView

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun ChatTopBar(user: User, onBackIconClick: () -> Unit) {

    Column {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.primary,
            navigationIcon = {
                IconButton(onBackIconClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        tint = Color.White, contentDescription = null
                    )
                }
            },
            actions = {
                Row(modifier = Modifier.padding(horizontal = 8.dp)) {
                    Surface(shape = CircleShape, modifier = Modifier.size(40.dp)) {
                        ImageView(url = user.imageUrl)
                    }
                }
            },
            title = {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.body1,
                )
            }
        )
    }
}