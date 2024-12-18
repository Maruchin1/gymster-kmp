package com.maruchin.gymster.screen.workouttemplate.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.maruchin.gymster.data.plans2.model.RenameWorkoutTemplateRequest
import com.maruchin.gymster.data.plans2.model.WorkoutTemplate
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlin.time.Duration.Companion.seconds

@OptIn(FlowPreview::class)
@Composable
internal fun EditableWorkoutTemplateName(
    workoutTemplate: WorkoutTemplate,
    onRenameWorkoutTemplate: (RenameWorkoutTemplateRequest) -> Unit,
    modifier: Modifier = Modifier
) {
    var value by rememberSaveable(workoutTemplate.name) { mutableStateOf(workoutTemplate.name) }

    LaunchedEffect(workoutTemplate) {
        snapshotFlow { value }.debounce(2.seconds).collect { newName ->
            val request = RenameWorkoutTemplateRequest(workoutTemplate.id, newName)
            onRenameWorkoutTemplate(request)
        }
    }

    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        textStyle = MaterialTheme.typography.displaySmall,
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            errorBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent
        ),
        placeholder = {
            Text(text = "Template name", style = MaterialTheme.typography.displaySmall)
        }
    )
}
