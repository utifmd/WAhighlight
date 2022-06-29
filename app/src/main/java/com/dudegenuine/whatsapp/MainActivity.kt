package com.dudegenuine.whatsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.dudegenuine.whatsapp.ui.compose.navigation.MainGraph
import com.dudegenuine.whatsapp.ui.compose.navigation.Screen
import com.dudegenuine.whatsapp.ui.compose.screen.main.MainViewModel
import com.dudegenuine.whatsapp.ui.compose.state.ScreenState
import com.dudegenuine.whatsapp.ui.theme.WhatsappTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val screenState: State<ScreenState?> = viewModel.screenStateFlow.collectAsState()
            val controller = rememberNavController()

            WhatsappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    MainGraph(
                        controller = controller,
                        viewModel = viewModel,
                        startDestination = Screen.Chats.route
                    )
                }
            }
            LaunchedEffect(screenState.value){
                Log.d("TAG", "onCreate: trigger ${screenState.value}")
                when(screenState.value){
                    is ScreenState.Navigate.To ->
                        with(screenState.value as ScreenState.Navigate.To){ controller.navigate(route, option) }
                    is ScreenState.Navigate.Back -> controller.popBackStack()
                }
            }
        }
    }
}
/*
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WhatsappTheme {
        Greeting("Android")
    }
}*/
