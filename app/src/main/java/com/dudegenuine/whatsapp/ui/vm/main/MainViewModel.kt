package com.dudegenuine.whatsapp.ui.vm.main

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.dudegenuine.whatsapp.data.remote.model.Call
import com.dudegenuine.whatsapp.data.remote.model.Chat
import com.dudegenuine.whatsapp.data.remote.model.Status
import com.dudegenuine.whatsapp.data.remote.model.User
import com.dudegenuine.whatsapp.domain.repository.Repository
import com.dudegenuine.whatsapp.ui.compose.navigation.Screen
import com.dudegenuine.whatsapp.ui.compose.state.ScreenState
import com.dudegenuine.whatsapp.ui.compose.utility.Constants.EMPTY_STRING
import com.dudegenuine.whatsapp.ui.compose.utility.Constants.NO_INTERNET
import com.dudegenuine.whatsapp.ui.compose.utility.Constants.NO_RESULT
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
class MainViewModel: ViewModel() {
    private val TAG: String = javaClass.simpleName
    private val repository: Repository = Repository()

    private val _screenStateFlow = MutableStateFlow<ScreenState?>(null)
    val screenStateFlow: StateFlow<ScreenState?> get() = _screenStateFlow

    private val _callsStateFlow = MutableStateFlow<List<Call>?>(null)
    val callsStateFlow get() = _callsStateFlow

    private val _chatsStateFlow = MutableStateFlow<List<Chat>?>(null)
    val chatsStateFlow get() = _chatsStateFlow

    private val _statusStateFlow = MutableStateFlow<List<Status>?>(null)
    val statusStateFlow get() = _statusStateFlow

    private val _loading = mutableStateOf(false)
    val loading get() = _loading

    private val _error = mutableStateOf(EMPTY_STRING)
    val error get() = _error

    init {
        getCalls()
        getChats()
        getStatus()
    }

    private fun getCalls() = viewModelScope.launch {
        try {
            _loading.value = true
            val calls = repository.getCalls()
            _callsStateFlow.emit(calls)

            if (calls.isEmpty())
                _error.value = NO_RESULT

        } catch (e: IOException){
            _error.value = NO_INTERNET
        } catch (e: HttpException){
            _error.value = e.localizedMessage ?: EMPTY_STRING
        } finally {
            _loading.value = false
        }
    }

    private fun getChats() = viewModelScope.launch {
        try {
            _loading.value = true
            val chats = repository.getChats()
            _chatsStateFlow.emit(chats)

            if (chats.isEmpty())
                _error.value = NO_RESULT

        } catch (e: IOException){
            _error.value = NO_INTERNET
        } catch (e: HttpException){
            _error.value = e.localizedMessage ?: EMPTY_STRING
        } finally {
            _loading.value = false
        }
    }

    private fun getStatus() = viewModelScope.launch {
        try {
            _loading.value = true
            val status = repository.getStatus()
            _statusStateFlow.emit(status)

            if (status.isEmpty())
                _error.value = NO_RESULT

        } catch (e: IOException){
            _error.value = NO_INTERNET
        } catch (e: HttpException){
            _error.value = e.localizedMessage ?: EMPTY_STRING
        } finally {
            _loading.value = false
        }
    }

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