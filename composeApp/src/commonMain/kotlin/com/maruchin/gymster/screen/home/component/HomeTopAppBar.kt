package com.maruchin.gymster.screen.home.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun HomeTopAppBar(
    topAppBarScrollBehavior: TopAppBarScrollBehavior,
    onOpenProfile: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text("Gymster")
        },
        actions = {
            IconButton(onClick = onOpenProfile) {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            }
        },
        scrollBehavior = topAppBarScrollBehavior
    )
}
