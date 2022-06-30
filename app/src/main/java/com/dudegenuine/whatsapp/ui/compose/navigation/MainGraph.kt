package com.dudegenuine.whatsapp.ui.compose.navigation

import android.net.Uri
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dudegenuine.whatsapp.data.local.addChat
import com.dudegenuine.whatsapp.domain.model.User
import com.dudegenuine.whatsapp.ui.compose.component.TabbedPager
import com.dudegenuine.whatsapp.ui.compose.screen.call.CallsView
import com.dudegenuine.whatsapp.ui.compose.screen.chat.ChatScreenView
import com.dudegenuine.whatsapp.ui.compose.screen.chat.ChatView
import com.dudegenuine.whatsapp.ui.compose.screen.status.StatusView
import com.dudegenuine.whatsapp.ui.vm.main.MainViewModel
import com.dudegenuine.whatsapp.ui.compose.utility.Constants.EMPTY_STRING
import com.dudegenuine.whatsapp.ui.compose.utility.Constants.URI_PARAM_USER_DATA
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.gson.Gson

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@ExperimentalPagerApi
@Composable
fun MainGraph(
    modifier: Modifier = Modifier,
    controller: NavHostController, viewModel: MainViewModel, startDestination: String) {
    val viewPager = remember{
        mutableListOf(Screen.Home.Call, Screen.Home.Chat, Screen.Home.Status)
    }
    NavHost(
        navController = controller,
        startDestination = startDestination){
        composable(route = Screen.Home.route){
            TabbedPager(modifier,
                startScreen = Screen.Home.Chat,
                pages = viewPager){ page ->
                Surface(
                    modifier = modifier,
                    color = MaterialTheme.colors.background) {
                    when(viewPager[page]){
                        is Screen.Home.Chat -> ChatView(viewModel::onDetailView)
                        is Screen.Home.Call -> CallsView()
                        is Screen.Home.Status -> StatusView()
                        else -> {}
                    }
                }
            }
        }

        /*
        * Detail graph
        * */
        composable(route = Screen.Home.Chat.Detail.routeWithArgs(
            "{$URI_PARAM_USER_DATA}")){ entry ->
            val params: String = entry.arguments?.getString(URI_PARAM_USER_DATA) ?: EMPTY_STRING
            val user = Gson().fromJson(params, User::class.java)
            ChatScreenView(
                user = user.copy(id = 2, imageUrl = Uri.decode(user.imageUrl)),
                onBackIconClick = viewModel::onBackPressed){ message ->
                if (message.isNotBlank()) addChat(message)
            }
        }
    }
}