package com.dudegenuine.whatsapp.ui.compose.screen.call

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dudegenuine.whatsapp.ui.vm.main.MainViewModel

//import com.dudegenuine.whatsapp.data.local.calls

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun CallsView(viewModel: MainViewModel) {
    val callsState = viewModel.callsStateFlow.collectAsState()
    Box(contentAlignment = Alignment.Center){
        if(viewModel.loading.value)
            CircularProgressIndicator()

        if (viewModel.error.value.isNotBlank())
            Text(text = viewModel.error.value)

        LazyColumn(Modifier.fillMaxSize()) {
            callsState.value?.let { list ->
                items(list) { call ->
                    CallsItem(call)
                    Divider()
                }
            }
        }
    }
}