package com.dudegenuine.whatsapp.ui.compose.screen.call

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dudegenuine.whatsapp.data.remote.model.Call
import com.dudegenuine.whatsapp.ui.compose.component.ImageView

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun CallsItem(call: Call, padding: Dp = 16.dp) {
    Column(
        Modifier
            .padding(padding)
            .fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Surface(shape = CircleShape, modifier = Modifier.size(40.dp)) {
                ImageView(url = call.imageUrl)
            }
            Column(modifier = Modifier.padding(start = padding)) {
                Text(call.name)
                Text(
                    call.time,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.primary,
                        textAlign = TextAlign.Center
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                /*ImageLoader(call.voiceStatus, modifier = Modifier)*/
            }
        }
    }
}