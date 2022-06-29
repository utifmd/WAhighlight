package com.dudegenuine.whatsapp.ui.compose.component

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dudegenuine.whatsapp.ui.compose.navigation.Screen

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun TabsPanel(
    initialScreen: Screen,
    onNavigate: (Screen) -> Unit) {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(initialScreen) }
    val tabs = remember{ mutableListOf(Screen.Calls, Screen.Chats, Screen.Status) }

    TabRow(
        selectedTabIndex = tabs.indexOf(initialScreen),
        tabs = {
            tabs.forEach { tab ->
                Tab(
                    text = { Text(text = tab.title.uppercase()) },
                    selected = tab == selectedTab,
                    onClick = {
                        setSelectedTab(tab)
                        onNavigate(tab)
                    }
                )
            }
        }
    )
}