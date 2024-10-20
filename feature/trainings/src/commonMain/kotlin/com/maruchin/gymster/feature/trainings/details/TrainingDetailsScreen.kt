package com.maruchin.gymster.feature.trainings.details

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.core.utils.format.format
import com.maruchin.gymster.data.trainings.model.Exercise
import com.maruchin.gymster.data.trainings.model.SetResult
import com.maruchin.gymster.data.trainings.model.Training
import com.maruchin.gymster.feature.trainings.forms.SetResultFormModal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// TODO Display date instead of complete button when training is completed and allow editing it

// TODO Show results from previous training

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun TrainingDetailsScreen(
    state: TrainingDetailsUiState,
    onBack: () -> Unit,
    onComplete: () -> Unit,
    onUpdateSetResult: (setResultId: String, weight: Double, reps: Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(training = state.training, onBack = onBack, onComplete = onComplete)
        }
    ) { contentPadding ->
        val loadedTraining = state.training ?: return@Scaffold
        val pagerState = rememberPagerState(
            initialPage = 0,
            pageCount = { loadedTraining.exercises.size }
        )
        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .imePadding()
                .padding(contentPadding)
        ) {
            ExercisesTabRow(pagerState = pagerState, training = loadedTraining, scope = scope)
            HorizontalPager(state = pagerState, modifier = Modifier.weight(1f)) { exerciseIndex ->
                val exercise = loadedTraining.exercises[exerciseIndex]
                ExercisePage(
                    exercise = exercise,
                    onUpdateSetResult = onUpdateSetResult
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(training: Training?, onBack: () -> Unit, onComplete: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = training?.name.orEmpty())
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBackIos,
                    contentDescription = null
                )
            }
        },
        actions = {
            TextButton(onClick = onComplete) {
                Text(text = "Complete")
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ExercisesTabRow(pagerState: PagerState, training: Training, scope: CoroutineScope) {
    TabRow(selectedTabIndex = pagerState.currentPage) {
        training.exercises.forEachIndexed { index, exercise ->
            Tab(
                selected = index == pagerState.currentPage,
                onClick = {
                    scope.launch { pagerState.animateScrollToPage(index) }
                },
                text = { Text(text = "${index + 1}") },
                icon = {
                    if (exercise.isComplete) {
                        Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null)
                    } else {
                        Icon(imageVector = Icons.Outlined.Circle, contentDescription = null)
                    }
                }
            )
        }
    }
}

@Composable
private fun ExercisePage(
    exercise: Exercise,
    onUpdateSetResult: (setResultId: String, weight: Double, reps: Int) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = exercise.name,
            style = MaterialTheme.typography.headlineMedium
        )
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            SetsCard(
                completedSets = exercise.setsResults.size,
                totalSets = exercise.sets,
                modifier = Modifier.weight(1f)
            )
            RepsCard(
                reps = exercise.reps,
                modifier = Modifier.weight(1f)
            )
        }
        SetResultsCard(
            expectedReps = exercise.reps,
            setResults = exercise.setsResults,
            onUpdateSetResult = onUpdateSetResult
        )
    }
}

@Composable
private fun SetsCard(completedSets: Int, totalSets: Int, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Sets", style = MaterialTheme.typography.titleSmall)
            Text(
                text = "$completedSets / $totalSets",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
private fun RepsCard(reps: IntRange, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Reps", style = MaterialTheme.typography.titleSmall)
            Text(
                text = reps.format(),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
private fun SetResultsCard(
    expectedReps: IntRange,
    setResults: List<SetResult>,
    onUpdateSetResult: (setResultId: String, weight: Double, reps: Int) -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Weight",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Reps",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.weight(1f)
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 12.dp),
            color = MaterialTheme.colorScheme.outline
        )
        setResults.forEachIndexed { index, setResult ->
            SetResultItem(
                index = index,
                expectedReps = expectedReps,
                setResult = setResult,
                onUpdate = onUpdateSetResult
            )
            if (setResult != setResults.last()) {
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}

@Composable
private fun SetResultItem(
    index: Int,
    expectedReps: IntRange,
    setResult: SetResult,
    onUpdate: (setResultId: String, weight: Double, reps: Int) -> Unit
) {
    val setNumber = index + 1
    var isEditing by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isEditing = true }
            .padding(horizontal = 12.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Set $setNumber",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = setResult.weight?.toString()?.let { "$it kg" }.orEmpty(),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = setResult.reps?.toString().orEmpty(),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
    }

    if (isEditing) {
        SetResultFormModal(
            index = index,
            expectedReps = expectedReps,
            setResult = setResult,
            onDismiss = { isEditing = false },
            onSave = onUpdate
        )
    }
}
