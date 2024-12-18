package com.maruchin.gymster.screen.workouttemplate.component

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
import com.maruchin.gymster.data.plans2.model.SetTemplate
import com.maruchin.gymster.data.trainings.model.EditSetRequest
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlin.time.Duration.Companion.seconds

@OptIn(FlowPreview::class)
@Composable
internal fun SetTemplateItem(
    index: Int,
    setTemplate: SetTemplate,
    onEdit: (EditSetRequest) -> Unit,
    onDelete: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val number = index + 1

    var weightInput by rememberSaveable(setTemplate.weight) {
        mutableStateOf(setTemplate.weight?.toString().orEmpty())
    }
    var repsInput by rememberSaveable(setTemplate.reps) {
        mutableStateOf(setTemplate.reps.toString())
    }

    fun handleEdit(weightInput: String, repsInput: String) {
        val weight = weightInput.toDoubleOrNull()
        val reps = repsInput.toIntOrNull() ?: return
        if (weight == setTemplate.weight && reps == setTemplate.reps) return
        val request = EditSetRequest(setTemplate.id, weight, reps)
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
        SetNumberLabel(
            number = number,
            modifier = Modifier.weight(weight = 1f)
        )
        WeightInput(
            value = weightInput,
            onValueChange = { weightInput = it },
            modifier = Modifier.weight(weight = 3f)
        )
        RepsInput(
            value = repsInput,
            onValueChange = { repsInput = it },
            modifier = Modifier.weight(weight = 3f)
        )
        DeleteSetButton(enabled = index > 0, onClick = { onDelete(setTemplate.id) })
    }
}

@Composable
private fun SetNumberLabel(number: Int, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(
                text = number.toString(),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
private fun WeightInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Center,
                    color = LocalContentColor.current
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun RepsInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Center,
                    color = LocalContentColor.current
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun DeleteSetButton(enabled: Boolean, onClick: () -> Unit) {
    IconButton(onClick = onClick, enabled = enabled) {
        Icon(imageVector = Icons.Rounded.Close, contentDescription = "Delete set")
    }
}
