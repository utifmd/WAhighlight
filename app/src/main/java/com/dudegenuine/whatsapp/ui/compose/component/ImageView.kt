package com.dudegenuine.whatsapp.ui.compose.component

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.ImageLoader
import coil.compose.rememberImagePainter

/**
 * Thu, 30 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun ImageView(modifier: Modifier = Modifier, url: String) {
    val painter = rememberImagePainter(data = url)
    Image(
        painter = painter,
        contentDescription = null,
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxSize()
            /*.clickable(
                onClick = {
                    onPressed.invoke(fileId)
                }
            )*/
    )
}