package com.dudegenuine.whatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.dudegenuine.whatsapp.ui.compose.navigation.MainGraph
import com.dudegenuine.whatsapp.ui.compose.navigation.Screen
import com.dudegenuine.whatsapp.ui.compose.component.TabsPanel
import com.dudegenuine.whatsapp.ui.vm.main.MainViewModel
import com.dudegenuine.whatsapp.ui.compose.state.ScreenState
import com.dudegenuine.whatsapp.ui.theme.WhatsappTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val screenState: State<ScreenState?> = viewModel.screenStateFlow.collectAsState()
            val initialScreen by remember{ mutableStateOf(Screen.Chats) }
            val controller = rememberNavController()

            WhatsappTheme {
                // A surface container using the 'background' color from the theme
                Column {
                    TopAppBar(
                        title = { Text(getString(R.string.app_name), color = Color.White) },
                        elevation = 0.dp
                    )
                    TabsPanel(initialScreen){
                        viewModel.onScreenStateFlowChange(ScreenState.Navigate.To(it.route))
                    }
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background) {
                        MainGraph(
                            controller = controller,
                            viewModel = viewModel,
                            startDestination = initialScreen.route
                        )
                    }
                }
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