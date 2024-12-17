package com.maruchin.gymster.screen.startworkout.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.maruchin.gymster.data.plans2.model.WorkoutTemplate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun WorkoutTemplatePreviewDialog(
    workoutTemplate: WorkoutTemplate,
    onDismiss: () -> Unit,
    onEdit: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            color = AlertDialogDefaults.containerColor,
            shape = AlertDialogDefaults.shape,
            modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
        ) {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = workoutTemplate.name)
                    },
                    navigationIcon = {
                        IconButton(onClick = onDismiss) {
                            Icon(imageVector = Icons.Rounded.Close, contentDescription = null)
                        }
                    },
                    actions = {
                        TextButton(
                            onClick = {
                                onEdit()
                                onDismiss()
                            }
                        ) {
                            Text(text = "Edit")
                        }
                    }
                )
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    workoutTemplate.exercises.forEach { exerciseTemplate ->
                        ExerciseTemplateItem(exerciseTemplate = exerciseTemplate)
                    }
                }
                Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    Text(text = "Start workout")
                }
            }
        }
    }
}
