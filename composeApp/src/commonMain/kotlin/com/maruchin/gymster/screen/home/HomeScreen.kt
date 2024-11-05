package com.maruchin.gymster.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.maruchin.gymster.screen.home.component.HomeTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(onOpenProfile: () -> Unit) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            HomeTopAppBar(
                topAppBarScrollBehavior = topAppBarScrollBehavior,
                onOpenProfile = onOpenProfile
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
        ) {
        }
    }
}
