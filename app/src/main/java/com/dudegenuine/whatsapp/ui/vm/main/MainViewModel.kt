package com.dudegenuine.whatsapp.ui.vm.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dudegenuine.whatsapp.ui.compose.state.ScreenState
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
    fun onScreenStateFlowChange(state: ScreenState){
        Log.d(TAG, "onScreenStateFlowChange: $state")
        viewModelScope.launch { _screenStateFlow.emit(state) }
    }
}