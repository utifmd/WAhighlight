package com.dudegenuine.whatsapp.ui.compose.state

import androidx.navigation.NavOptions

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
sealed class ScreenState{
    object Navigate{
        data class To(
            val route: String,
            val option: NavOptions? = null): ScreenState()
        object Back: ScreenState()
    }
}
