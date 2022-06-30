package com.dudegenuine.whatsapp.ui.compose.navigation

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
sealed class Screen(
    val title: String = "Tab", val route: String) {

    fun routeWithArgs(vararg args: String): String {
        return buildString {
            append(route)

            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    object Home: Screen("Home", "home"){
        object Call: Screen("Call", "HomeCall")
        object Chat: Screen("Chat", "HomeChat"){
            object Detail: Screen("Detail", "HomeChatDetail")
        }
        object Status: Screen("Status", "HomeStatus")
    }
}