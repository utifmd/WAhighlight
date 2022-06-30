package com.dudegenuine.whatsapp.ui.vm.main

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.dudegenuine.whatsapp.domain.model.User
import com.dudegenuine.whatsapp.ui.compose.navigation.Screen
import com.dudegenuine.whatsapp.ui.compose.state.ScreenState
import com.dudegenuine.whatsapp.ui.compose.utility.Constants
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
class MainViewModel: ViewModel() {
    private val TAG: String = javaClass.simpleName
    private val _screenStateFlow = MutableStateFlow<ScreenState?>(null)
    val screenStateFlow: StateFlow<ScreenState?> get() = _screenStateFlow
    private fun onScreenStateFlowChange(state: ScreenState){
        Log.d(TAG, "onScreenStateFlowChange: $state")
        viewModelScope.launch { _screenStateFlow.emit(state) }
    }
    fun onDetailView(user: User){
        val params = Gson().toJson(user.copy(imageUrl = Uri.encode(user.imageUrl)))
        onNavigateTo(Screen.Home.Chat.Detail.routeWithArgs(params))
    }
    fun onNavigateTo(route: String, option: NavOptions? = null) =
        onScreenStateFlowChange(ScreenState.Navigate.To(route, option))
    fun onBackPressed() =
        onScreenStateFlowChange(ScreenState.Navigate.Back)
}