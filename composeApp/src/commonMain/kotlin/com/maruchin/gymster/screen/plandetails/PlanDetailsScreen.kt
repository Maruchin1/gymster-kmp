package com.maruchin.gymster.screen.plandetails

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBackIos
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.rounded.FitnessCenter
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.plans.model.Plan
import com.maruchin.gymster.data.plans.model.PlanExercise
import com.maruchin.gymster.data.plans.model.PlanTraining
import com.maruchin.gymster.ui.forms.ExerciseFormModal
import com.maruchin.gymster.ui.forms.PlanFormModal
import com.maruchin.gymster.ui.forms.TrainingFormModal

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
    onDeleteExercise: (exerciseId: String) -> Unit,
    onActivatePlan: () -> Unit,
    onDeactivatePlan: () -> Unit,
    onClearNotification: () -> Unit
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val lazyListState = rememberLazyListState()
    val snackbarHostState = remember { SnackbarHostState() }
    val currentOnClearNotification by rememberUpdatedState(onClearNotification)
    var isEditingPlan by remember { mutableStateOf(false) }
    var isAddingTraining by remember { mutableStateOf(false) }

    state.notification?.let {
        LaunchedEffect(Unit) {
            val message = when (it) {
                PlanDetailsNotification.PLAN_ACTIVATED -> "Plan activated"
                PlanDetailsNotification.PLAN_DEACTIVATED -> "Plan deactivated"
            }
            snackbarHostState.showSnackbar(message)
            currentOnClearNotification()
        }
    }

    Scaffold(
        topBar = {
            TopBar(
                plan = state.plan,
                scrollBehavior = topAppBarScrollBehavior,
                onBack = onBack,
                onDeactivatePlan = onDeactivatePlan,
                onChangePlanName = { isEditingPlan = true },
                onDeletePlan = onDeletePlan
            )
        },
        floatingActionButton = {
            if (state.plan?.isActive == false) {
                ActivatePlanButton(onClick = onActivatePlan, lazyListState = lazyListState)
            }
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { contentPadding ->
        val loadedPlan = state.plan ?: return@Scaffold

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
                    onUpdateExercise = onUpdateExercise,
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
}

@Composable
private fun ActivatePlanButton(onClick: () -> Unit, lazyListState: LazyListState) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        text = {
            Text(text = "Activate plan")
        },
        icon = {
            Icon(imageVector = Icons.Rounded.FitnessCenter, contentDescription = null)
        },
        expanded = lazyListState.firstVisibleItemIndex == 0
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(
    plan: Plan?,
    scrollBehavior: TopAppBarScrollBehavior,
    onBack: () -> Unit,
    onDeactivatePlan: () -> Unit,
    onChangePlanName: () -> Unit,
    onDeletePlan: () -> Unit
) {
    var isDeactivatingPlan by remember { mutableStateOf(false) }
    var isMoreMenuVisible by remember { mutableStateOf(false) }

    LargeTopAppBar(
        title = {
            Text(plan?.name.orEmpty())
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Rounded.ArrowBackIos, contentDescription = null)
            }
        },
        actions = {
            if (plan != null && plan.isActive) {
                FilterChip(
                    label = {
                        Text(text = "Active")
                    },
                    selected = true,
                    onClick = { isDeactivatingPlan = true },
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
            Box {
                IconButton(onClick = { isMoreMenuVisible = true }) {
                    Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = null)
                }
                if (isMoreMenuVisible) {
                    DropdownMenu(
                        expanded = isMoreMenuVisible,
                        onDismissRequest = { isMoreMenuVisible = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text(text = "Change name") },
                            onClick = {
                                onChangePlanName()
                                isMoreMenuVisible = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(text = "Delete plan") },
                            onClick = {
                                onDeletePlan()
                                isMoreMenuVisible = false
                            }
                        )
                    }
                }
            }
        },
        scrollBehavior = scrollBehavior
    )

    if (isDeactivatingPlan) {
        AlertDialog(
            onDismissRequest = { isDeactivatingPlan = false },
            title = {
                Text(text = "Deactivate plan")
            },
            text = {
                Text(text = "Are you sure you want to deactivate this plan?")
            },
            confirmButton = {
                TextButton(
                    onClick = { isDeactivatingPlan = false }
                ) {
                    Text(text = "Cancel")
                }
                TextButton(
                    onClick = {
                        isDeactivatingPlan = false
                        onDeactivatePlan()
                    }
                ) {
                    Text(text = "Deactivate")
                }
            }
        )
    }
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
        TrainingHeader(
            training = training,
            onUpdateTraining = onUpdateTraining,
            onDeleteTraining = onDeleteTraining
        )
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
                onDismiss = { isAddingExercise = false },
                onSave = { name, sets, reps ->
                    onAddExercise(name, sets, reps)
                    isAddingExercise = false
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TrainingHeader(
    training: PlanTraining,
    onUpdateTraining: (name: String) -> Unit,
    onDeleteTraining: () -> Unit
) {
    var isEditingTraining by remember { mutableStateOf(false) }

    Column {
        HorizontalDivider()
        TopAppBar(
            title = {
                Text(text = training.name)
            },
            actions = {
                TextButton(onClick = { isEditingTraining = true }) {
                    Text(text = "Edit")
                }
            },
            windowInsets = WindowInsets(top = 0)
        )
        HorizontalDivider()
    }
    if (isEditingTraining) {
        TrainingFormModal(
            training = training,
            onDismiss = { isEditingTraining = false },
            onSave = onUpdateTraining,
            onDelete = onDeleteTraining
        )
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

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        onClick = { isEditingExercise = true }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(12.dp)) {
            Column(
                modifier = Modifier.weight(1f),
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
            }
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null
            )
        }
    }

    if (isEditingExercise) {
        ExerciseFormModal(
            exercise = exercise,
            onSave = onUpdateExercise,
            onDelete = onDeleteExercise,
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
