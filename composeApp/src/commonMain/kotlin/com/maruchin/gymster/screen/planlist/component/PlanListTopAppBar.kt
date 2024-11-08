package com.maruchin.gymster.screen.planlist.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.maruchin.gymster.data.plans.model.AddPlanRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PlanListTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onBack: () -> Unit,
    onAddPlan: (AddPlanRequest) -> Unit,
    modifier: Modifier = Modifier
) {
    var isAddingPlan by rememberSaveable { mutableStateOf(false) }

    LargeTopAppBar(
        title = {
            Text(text = "My plans")
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBackIos,
                    contentDescription = null
                )
            }
        },
        actions = {
            TextButton(onClick = { isAddingPlan = true }) {
                Text("Add plan")
            }
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier
    )

    if (isAddingPlan) {
        AddPlanModal(onDismiss = { isAddingPlan = false }, onSave = onAddPlan)
    }
}
