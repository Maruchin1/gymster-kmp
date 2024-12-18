package com.maruchin.gymster.screen.workouttemplate.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun WorkoutTemplateTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onClose: () -> Unit,
    onSave: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Edit Template")
        },
        navigationIcon = {
            IconButton(onClick = onClose) {
                Icon(imageVector = Icons.Rounded.Close, contentDescription = "Close")
            }
        },
        actions = {
            TextButton(onClick = onSave) {
                Text(text = "Save")
            }
        },
        modifier = modifier,
        scrollBehavior = scrollBehavior
    )
}
