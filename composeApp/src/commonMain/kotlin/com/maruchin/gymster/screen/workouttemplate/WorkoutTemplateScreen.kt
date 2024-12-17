package com.maruchin.gymster.screen.workouttemplate

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.maruchin.gymster.screen.workouttemplate.component.WorkoutTemplateTopBar

@Composable
internal fun WorkoutTemplateScreen(onClose: () -> Unit) {
    Scaffold(
        topBar = {
            WorkoutTemplateTopBar(onClose = onClose, onSave = {})
        }
    ) { innerPadding ->
    }
}
