package com.maruchin.gymster.screen.planlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.plans.model.AddPlanRequest
import com.maruchin.gymster.screen.planlist.component.PlanItem
import com.maruchin.gymster.screen.planlist.component.PlanListTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PlanListScreen(
    state: PlanListUiState,
    onBack: () -> Unit,
    onOpenPlan: (Int) -> Unit,
    onAddPlan: (AddPlanRequest) -> Unit,
    onClearError: () -> Unit
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState() }

    if (state.isError) {
        LaunchedEffect(Unit) {
            snackbarHostState.showSnackbar("Something went wrong")
            onClearError()
        }
    }

    Scaffold(
        topBar = {
            PlanListTopAppBar(
                scrollBehavior = topAppBarScrollBehavior,
                onBack = onBack,
                onAddPlan = onAddPlan
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            LazyColumn(
                modifier = Modifier
                    .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.plans, key = { it.id }) { plan ->
                    PlanItem(
                        plan = plan,
                        onClick = { onOpenPlan(plan.id) }
                    )
                }
            }
            if (state.isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
