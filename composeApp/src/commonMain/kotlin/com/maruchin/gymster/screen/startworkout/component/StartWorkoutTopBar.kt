package com.maruchin.gymster.screen.startworkout.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.maruchin.gymster.data.plans2.model.AddPlanRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun StartWorkoutTopBar(
    scrollBehavior: TopAppBarScrollBehavior?,
    onAddPlan: (AddPlanRequest) -> Unit,
    modifier: Modifier = Modifier
) {
    var isAddingPlan by rememberSaveable { mutableStateOf(false) }

    MediumTopAppBar(
        title = {
            Text(text = "Start workout")
        },
        actions = {
            TextButton(onClick = { isAddingPlan = true }) {
                Text(text = "Add plan")
            }
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier
    )

    if (isAddingPlan) {
        AddPlanModal(
            onDismiss = { isAddingPlan = false },
            onSave = onAddPlan
        )
    }
}
