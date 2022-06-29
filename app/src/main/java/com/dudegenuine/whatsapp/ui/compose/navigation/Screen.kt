package com.dudegenuine.whatsapp.ui.compose.navigation

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
sealed class Screen(
    val title: String = "Tab", val route: String) {

    object Calls: Screen("Calls", "Calls")
    object Chats: Screen("Chats", "Chats")
    object Status: Screen("Status", "Status")

    /*CALLS(title = ),
    CHATS(title = "Chats"),
    STATUS(title = "Status")*/
}