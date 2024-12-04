package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.trainings.model.AddSetRequest
import com.maruchin.gymster.data.trainings.model.EditSetRequest
import com.maruchin.gymster.data.trainings.model.EditTrainingRequest
import com.maruchin.gymster.data.trainings.model.Training

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TrainingPage(
    training: Training,
    topAppBarScrollBehavior: TopAppBarScrollBehavior,
    onEditSet: (EditSetRequest) -> Unit,
    onDeleteSet: (Int) -> Unit,
    onAddSet: (AddSetRequest) -> Unit,
    onAddExercise: (Int) -> Unit,
    onEditTraining: (EditTrainingRequest) -> Unit,
    onDeleteTraining: (Int) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
    ) {
        training.exercises.forEach { exercise ->
            item {
                ExerciseItem(
                    exercise = exercise,
                    modifier = Modifier.padding(16.dp)
                )
            }
            item {
                ExerciseSetLabels(
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    exercise.sets.forEachIndexed { index, exerciseSet ->
                        ExerciseSetItem(
                            index = index,
                            set = exerciseSet,
                            onEdit = onEditSet,
                            onDelete = onDeleteSet,
                            modifier = Modifier.padding(
                                start = 16.dp,
                                end = 8.dp
                            )
                        )
                    }
                }
            }
            item {
                AddExerciseSetButton(
                    exercise = exercise,
                    onClick = onAddSet,
                    modifier = Modifier.padding(16.dp)
                )
            }
            item {
                HorizontalDivider()
            }
        }
        item {
            TrainingActions(
                training = training,
                onAddExercise = onAddExercise,
                onEditTraining = onEditTraining,
                onDeleteTraining = onDeleteTraining,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
