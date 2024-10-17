package com.maruchin.gymster.feature.plans.plandetails

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.plans.model.Plan
import com.maruchin.gymster.data.plans.model.PlanExercise
import com.maruchin.gymster.data.plans.model.PlanTraining
import com.maruchin.gymster.feature.plans.forms.ExerciseFormModal
import com.maruchin.gymster.feature.plans.forms.PlanFormModal
import com.maruchin.gymster.feature.plans.forms.TrainingFormModal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PlanDetailsScreen(
    state: PlanDetailsUiState,
    onBack: () -> Unit,
    onUpdatePlan: (name: String) -> Unit,
    onDeletePlan: () -> Unit,
    onAddTraining: (name: String) -> Unit,
    onUpdateTraining: (trainingId: String, name: String) -> Unit,
    onDeleteTraining: (trainingId: String) -> Unit,
    onAddExercise: (trainingId: String, name: String, sets: Int, reps: IntRange) -> Unit,
    onUpdateExercise: (exerciseId: String, name: String, sets: Int, reps: IntRange) -> Unit,
    onDeleteExercise: (exerciseId: String) -> Unit
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    var isEditingPlan by remember { mutableStateOf(false) }
    var isAddingTraining by remember { mutableStateOf(false) }
    var editedTraining by remember { mutableStateOf<PlanTraining?>(null) }

    Scaffold(
        topBar = {
            TopBar(
                plan = state.plan,
                scrollBehavior = topAppBarScrollBehavior,
                onBack = onBack,
                onEditPlan = { isEditingPlan = true },
                onDeletePlan = onDeletePlan
            )
        }
    ) { contentPadding ->
        val loadedPlan = state.plan ?: return@Scaffold
        val lazyListState = rememberLazyListState()

        LazyColumn(
            state = lazyListState,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                .padding(contentPadding)
        ) {
            loadedPlan.trainings.forEach { training ->
                trainingSection(
                    training = training,
                    onUpdateTraining = { name ->
                        onUpdateTraining(training.id, name)
                    },
                    onDeleteTraining = { onDeleteTraining(training.id) },
                    onUpdateExercise = { exerciseId, name, sets, reps ->
                        onUpdateExercise(exerciseId, name, sets, reps)
                    },
                    onDeleteExercise = onDeleteExercise,
                    onAddExercise = { name, sets, reps ->
                        onAddExercise(training.id, name, sets, reps)
                    }
                )
            }
            item {
                AddTrainingButton(onClick = { isAddingTraining = true })
            }
        }
    }

    if (isEditingPlan) {
        PlanFormModal(
            plan = state.plan,
            onDismiss = { isEditingPlan = false },
            onSave = onUpdatePlan
        )
    }
    if (isAddingTraining) {
        TrainingFormModal(
            training = null,
            onDismiss = { isAddingTraining = false },
            onSave = onAddTraining
        )
    }
    editedTraining?.let { training ->
        TrainingFormModal(
            training = editedTraining,
            onDismiss = { editedTraining = null },
            onSave = { onUpdateTraining(training.id, it) }
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(
    plan: Plan?,
    scrollBehavior: TopAppBarScrollBehavior,
    onBack: () -> Unit,
    onEditPlan: () -> Unit,
    onDeletePlan: () -> Unit
) {
    LargeTopAppBar(
        title = {
            Text(plan?.name.orEmpty())
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = onEditPlan) {
                Icon(imageVector = Icons.Outlined.Edit, contentDescription = null)
            }
            IconButton(onClick = onDeletePlan) {
                Icon(imageVector = Icons.Outlined.Delete, contentDescription = null)
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalFoundationApi::class)
private fun LazyListScope.trainingSection(
    training: PlanTraining,
    onUpdateTraining: (name: String) -> Unit,
    onDeleteTraining: () -> Unit,
    onAddExercise: (name: String, sets: Int, reps: IntRange) -> Unit,
    onUpdateExercise: (exerciseId: String, name: String, sets: Int, reps: IntRange) -> Unit,
    onDeleteExercise: (exerciseId: String) -> Unit
) {
    stickyHeader {
        var isEditingTraining by rememberSaveable { mutableStateOf(false) }

        TrainingHeader(
            training = training,
            onEditTraining = { isEditingTraining = true },
            onDeleteTraining = onDeleteTraining
        )

        if (isEditingTraining) {
            TrainingFormModal(
                training = training,
                onDismiss = { isEditingTraining = false },
                onSave = onUpdateTraining
            )
        }
    }
    items(training.exercises, key = { it.id }) { exercise ->
        ExerciseItem(
            exercise = exercise,
            onUpdateExercise = { name, sets, reps ->
                onUpdateExercise(exercise.id, name, sets, reps)
            },
            onDeleteExercise = { onDeleteExercise(exercise.id) }
        )
    }
    item {
        var isAddingExercise by rememberSaveable { mutableStateOf(false) }

        AddExerciseButton(onClick = { isAddingExercise = true })

        if (isAddingExercise) {
            ExerciseFormModal(
                exercise = null,
                onSave = { name, sets, reps ->
                    onAddExercise(name, sets, reps)
                    isAddingExercise = false
                },
                onDismiss = { isAddingExercise = false }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TrainingHeader(
    training: PlanTraining,
    onEditTraining: () -> Unit,
    onDeleteTraining: () -> Unit
) {
    Column {
        HorizontalDivider()
        TopAppBar(
            title = {
                Text(text = training.name)
            },
            actions = {
                IconButton(onClick = onEditTraining) {
                    Icon(imageVector = Icons.Outlined.Edit, contentDescription = null)
                }
                IconButton(onClick = onDeleteTraining) {
                    Icon(imageVector = Icons.Outlined.Delete, contentDescription = null)
                }
            },
            windowInsets = WindowInsets(top = 0)
        )
        HorizontalDivider()
    }
}

@Composable
private fun AddTrainingButton(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.EditCalendar,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
        Text(text = "Add training")
    }
}

@Composable
private fun ExerciseItem(
    exercise: PlanExercise,
    onUpdateExercise: (name: String, sets: Int, reps: IntRange) -> Unit,
    onDeleteExercise: () -> Unit
) {
    var isEditingExercise by rememberSaveable { mutableStateOf(false) }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 12.dp, start = 12.dp, end = 8.dp, bottom = 2.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = exercise.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Sets: ${exercise.sets}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Reps: ${exercise.reps}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    AssistChip(
                        onClick = { isEditingExercise = true },
                        label = {
                            Text(text = "Edit")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = null,
                                modifier = Modifier.size(AssistChipDefaults.IconSize)
                            )
                        }
                    )
                    AssistChip(
                        onClick = onDeleteExercise,
                        label = {
                            Text(text = "Delete")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Delete,
                                contentDescription = null,
                                modifier = Modifier.size(AssistChipDefaults.IconSize)

                            )
                        }
                    )
                }
            }
        }
    }

    if (isEditingExercise) {
        ExerciseFormModal(
            exercise = exercise,
            onSave = onUpdateExercise,
            onDismiss = { isEditingExercise = false }
        )
    }
}

@Composable
private fun AddExerciseButton(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.FitnessCenter,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
        Text(text = "Add exercise")
    }
}
