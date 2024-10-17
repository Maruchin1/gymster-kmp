package com.maruchin.gymster.feature.plans.planlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Dataset
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.plans.model.Plan
import com.maruchin.gymster.data.plans.model.PlanTraining
import com.maruchin.gymster.feature.plans.forms.PlanFormModal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PlanListScreen(
    state: PlanListUiState,
    onBack: () -> Unit,
    onSeedPlans: () -> Unit,
    onOpenPlan: (planId: String) -> Unit,
    onCreatePlan: (name: String) -> Unit
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            TopBar(
                scrollBehavior = topAppBarScrollBehavior,
                onBack = onBack,
                onSeedPlans = onSeedPlans
            )
        },
        floatingActionButton = {
            CreatePlanButton(onCreatePlan = onCreatePlan)
        }
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier
                .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                .padding(contentPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.plans, key = { it.id }) { plan ->
                PlanItem(plan = plan, onClick = { onOpenPlan(plan.id) })
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onBack: () -> Unit,
    onSeedPlans: () -> Unit
) {
    LargeTopAppBar(
        title = {
            Text("Training plans")
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = onSeedPlans) {
                Icon(imageVector = Icons.Default.Dataset, contentDescription = null)
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Composable
private fun PlanItem(plan: Plan, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = plan.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
                if (plan.isActive) {
                    FilterChip(selected = true, label = { Text(text = "Active") }, onClick = {})
                }
            }
            if (plan.trainings.isEmpty()) {
                Text(text = "No trainings", style = MaterialTheme.typography.titleSmall)
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    plan.trainings.forEachIndexed { index, training ->
                        HorizontalDivider(color = MaterialTheme.colorScheme.outline)
                        TrainingItem(index = index, training = training)
                    }
                }
            }
        }
    }
}

@Composable
private fun TrainingItem(index: Int, training: PlanTraining) {
    val number = index + 1
    val exercisesCount = training.exercises.size

    Column {
        Text(
            text = "Training $number - ${training.name}",
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "$exercisesCount exercises", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun CreatePlanButton(onCreatePlan: (name: String) -> Unit) {
    var isAddingPlan by rememberSaveable { mutableStateOf(false) }

    FloatingActionButton(
        onClick = { isAddingPlan = true },
        modifier = Modifier.size(56.dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = null,
            modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize)
        )
    }

    if (isAddingPlan) {
        PlanFormModal(
            plan = null,
            onDismiss = { isAddingPlan = false },
            onSave = onCreatePlan
        )
    }
}
