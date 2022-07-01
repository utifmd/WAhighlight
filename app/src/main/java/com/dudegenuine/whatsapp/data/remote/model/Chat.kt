package com.dudegenuine.whatsapp.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
data class Chat(
    val name: String,
    val url: String,

    val chat: String,
    val time: String,

    @SerializedName("badge")
    val unreadCount: String
)
