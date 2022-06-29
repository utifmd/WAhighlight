package com.dudegenuine.whatsapp.ui.compose.navigation

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dudegenuine.whatsapp.ui.vm.main.MainViewModel
import com.dudegenuine.whatsapp.ui.compose.state.ScreenState

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun MainGraph(
    controller: NavHostController, viewModel: MainViewModel, startDestination: String) {

    NavHost(
        navController = controller,
        startDestination = startDestination){
        composable(route = Screen.Calls.route){
            val option = NavOptions.Builder().setPopUpTo(Screen.Chats.route, inclusive = true).build()
            val chatState = ScreenState.Navigate.To(Screen.Chats.route, option)
            Text(text = "Screen.Calls.title",
                modifier = Modifier.clickable { viewModel.onScreenStateFlowChange(chatState) } )
        }
        composable(route = Screen.Chats.route){
            val statusState = ScreenState.Navigate.To(Screen.Status.route)
            Text(text = "Screen.Chats.title",
                modifier = Modifier.clickable { viewModel.onScreenStateFlowChange(statusState) } )
        }
        composable(route = Screen.Status.route){
            val callsState = ScreenState.Navigate.To(Screen.Calls.route)
            Text(text = "Screen.Status.title",
                modifier = Modifier.clickable { viewModel.onScreenStateFlowChange(callsState) } )
        }
    }
}