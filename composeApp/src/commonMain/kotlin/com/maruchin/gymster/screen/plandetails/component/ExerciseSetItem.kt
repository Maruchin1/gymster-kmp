package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.trainings.model.EditSetRequest
import com.maruchin.gymster.data.trainings.model.ExerciseSet
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce

@OptIn(FlowPreview::class)
@Composable
internal fun ExerciseSetItem(
    index: Int,
    set: ExerciseSet,
    onEdit: (EditSetRequest) -> Unit,
    onDelete: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val number = index + 1

    var weightInput by rememberSaveable(set.weight) {
        mutableStateOf(set.weight?.toString().orEmpty())
    }
    var repsInput by rememberSaveable(set.reps) {
        mutableStateOf(set.reps.toString())
    }

    fun handleEdit(weightInput: String, repsInput: String) {
        val weight = weightInput.toDoubleOrNull()
        val reps = repsInput.toIntOrNull() ?: return
        if (weight == set.weight && reps == set.reps) return
        val request = EditSetRequest(set.id, weight, reps)
        onEdit(request)
    }

    LaunchedEffect(Unit) {
        combine(
            snapshotFlow { weightInput }.debounce(2.seconds),
            snapshotFlow { repsInput }.debounce(2.seconds),
            ::handleEdit
        ).collect {}
    }

    DisposableEffect(Unit) {
        onDispose {
            handleEdit(weightInput, repsInput)
        }
    }

    Row(
        modifier = Modifier.height(IntrinsicSize.Min).then(modifier),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Card(modifier = Modifier.weight(1f)) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(
                    text = number.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        Card(modifier = Modifier.weight(3f)) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                BasicTextField(
                    value = weightInput,
                    onValueChange = { weightInput = it },
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        textAlign = TextAlign.Center,
                        color = LocalContentColor.current
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Card(modifier = Modifier.weight(3f)) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                BasicTextField(
                    value = repsInput,
                    onValueChange = { repsInput = it },
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        textAlign = TextAlign.Center,
                        color = LocalContentColor.current
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        IconButton(onClick = { onDelete(set.id) }) {
            Icon(imageVector = Icons.Rounded.Close, contentDescription = "Delete set")
        }
    }
}
