package com.maruchin.gymster.screen.startworkout.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun StartWorkoutTopBar(
    scrollBehavior: TopAppBarScrollBehavior?,
    modifier: Modifier = Modifier
) {
    MediumTopAppBar(
        title = {
            Text(text = "Start workout")
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier
    )
}
