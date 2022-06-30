package com.dudegenuine.whatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.dudegenuine.whatsapp.ui.compose.navigation.MainGraph
import com.dudegenuine.whatsapp.ui.compose.navigation.Screen
import com.dudegenuine.whatsapp.ui.vm.main.MainViewModel
import com.dudegenuine.whatsapp.ui.compose.state.ScreenState
import com.dudegenuine.whatsapp.ui.theme.WhatsappTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val screenState: State<ScreenState?> = viewModel.screenStateFlow.collectAsState()
            val controller = rememberNavController()

            WhatsappTheme {
                // A surface container using the 'background' color from the theme
                MainGraph(
                    controller = controller,
                    viewModel = viewModel,
                    startDestination = Screen.Home.route
                )
            }
            LaunchedEffect(screenState.value){
                when(screenState.value){
                    is ScreenState.Navigate.To ->
                        with(screenState.value as ScreenState.Navigate.To){ controller.navigate(route, option) }
                    is ScreenState.Navigate.Back -> controller.popBackStack()
                }
            }
        }
    }
}