package com.maruchin.gymster.screen.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.screen.profile.component.EmailItem
import com.maruchin.gymster.screen.profile.component.LogoutItem
import com.maruchin.gymster.screen.profile.component.ProfileTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProfileScreen(state: ProfileUiState, onBack: () -> Unit, onLogout: () -> Unit) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            ProfileTopAppBar(
                userProfile = state.userProfile,
                scrollBehavior = topAppBarScrollBehavior,
                onBack = onBack
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            if (state.userProfile != null) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                ) {
                    EmailItem(userProfile = state.userProfile)
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                    LogoutItem(onLogout = onLogout)
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                }
            }
            if (state.isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
