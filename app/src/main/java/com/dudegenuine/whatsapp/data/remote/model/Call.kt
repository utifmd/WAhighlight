package com.dudegenuine.whatsapp.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
data class Call(
    val name: String,
    val imageUrl: String,
    val time: String,
    val voiceStatus: Int
)