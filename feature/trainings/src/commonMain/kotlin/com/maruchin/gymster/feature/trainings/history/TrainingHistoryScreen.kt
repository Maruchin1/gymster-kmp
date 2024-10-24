package com.maruchin.gymster.feature.trainings.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBackIos
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.core.ui.components.TrainingItem
import com.maruchin.gymster.data.trainings.model.TrainingWeek

// TODO Option to delete training week

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TrainingHistoryScreen(
    state: TrainingHistoryUiState,
    onBack: () -> Unit,
    onOpenTraining: (String) -> Unit
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(text = "Training history")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBackIos,
                            contentDescription = null
                        )
                    }
                },
                scrollBehavior = topAppBarScrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(state.trainingWeeks) { week ->
                TrainingWeekItem(week = week, onOpenTraining = onOpenTraining)
            }
        }
    }
}

@Composable
private fun TrainingWeekItem(week: TrainingWeek, onOpenTraining: (String) -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        week.trainings.forEach { training ->
            TrainingItem(
                isComplete = training.isComplete,
                name = training.name,
                exercisesCount = training.exercises.size,
                date = training.date,
                onClick = { onOpenTraining(training.id) }
            )
            if (training != week.trainings.last()) {
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outline,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
        }
    }
}
