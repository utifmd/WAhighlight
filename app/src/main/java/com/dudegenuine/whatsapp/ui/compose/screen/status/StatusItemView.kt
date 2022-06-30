package com.dudegenuine.whatsapp.ui.compose.screen.status

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dudegenuine.whatsapp.domain.model.Status
import com.dudegenuine.whatsapp.ui.compose.component.ImageView
import com.dudegenuine.whatsapp.ui.theme.ColorPrimary

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun StatusItemView(status: Status) {
    val padding = 16.dp
    Column(
        Modifier
            .padding(padding)
            .fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Surface(shape = CircleShape, modifier = Modifier.size(40.dp)) {
                ImageView(url = status.imageUrl)
            }
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(status.name)
                Text(
                    status.time,
                    color = MaterialTheme.colors.primary,
                    style = TextStyle(
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}