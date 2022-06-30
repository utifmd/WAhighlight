package com.dudegenuine.whatsapp.ui.compose.utility

import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 * Thu, 30 Jun 2022
 * Whatsapp by utifmd
 **/
object Constants {
    const val URI_PARAM_USER_DATA = "URI_PARAM_USER_DATA"
    const val URI_PARAM_USER_NAME = "URI_PARAM_USER_NAME"
    const val URI_PARAM_USER_IMG_URL = "URI_PARAM_USER_IMG_URL"
    const val EMPTY_STRING = ""

    fun gson(): Gson {
        return GsonBuilder()
            .create()
    }
}