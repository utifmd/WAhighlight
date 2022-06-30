package com.dudegenuine.whatsapp.ui.compose.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.dudegenuine.whatsapp.ui.compose.navigation.Screen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerScope
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@ExperimentalPagerApi
@Composable
fun TabbedPager(
    modifier: Modifier = Modifier,
    pages: List<Screen>,
    content: @Composable PagerScope.(page: Int) -> Unit){
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    fun seekToPage(page: Int) = scope.launch {
        pagerState.animateScrollToPage(page)
    }

    Column {
        TabRow(
            modifier = modifier,
            // Our selected tab is our current page
            selectedTabIndex = pagerState.currentPage,
            // Override the indicator, using the provided pagerTabIndicatorOffset modifier
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
                )
            }
        ) {
            // Add tabs for all of our pages
            pages.forEachIndexed { index, screen ->
                Tab(
                    text = { Text(screen.title) },
                    selected = pagerState.currentPage == index,
                    onClick = { seekToPage(index) },
                )
            }
        }

        HorizontalPager(
            count = pages.size,
            state = pagerState,
            content = content
        )
    }
}