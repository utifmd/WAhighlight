package com.dudegenuine.whatsapp.ui.compose.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dudegenuine.whatsapp.R
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
    modifier: Modifier = Modifier, startScreen: Screen,
    pages: List<Screen>,
    content: @Composable PagerScope.(page: Int) -> Unit){
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = pages.indexOf(startScreen))

    fun seekToPage(page: Int) = scope.launch {
        pagerState.animateScrollToPage(page)
    }

    Column {
        TopAppBar(
            title = { Text(stringResource(R.string.app_name), color = Color.White) },
            /*backgroundColor = MaterialTheme.colors.primary,*/
            elevation = 0.dp
        )
        TabRow(
            modifier = modifier,
            /*backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onBackground,*/
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