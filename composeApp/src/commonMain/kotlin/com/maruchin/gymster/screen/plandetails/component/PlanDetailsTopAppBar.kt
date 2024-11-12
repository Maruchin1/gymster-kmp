package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.MoreHoriz
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.maruchin.gymster.data.plans.model.EditPlanRequest
import com.maruchin.gymster.data.plans.model.Plan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PlanDetailsTopAppBar(
    plan: Plan?,
    scrollBehavior: TopAppBarScrollBehavior,
    onBack: () -> Unit,
    onEditPlan: (EditPlanRequest) -> Unit,
    onDeletePlan: (Int) -> Unit
) {
    var isMenuOpen by rememberSaveable { mutableStateOf(false) }
    var isEditing by rememberSaveable { mutableStateOf(false) }
    var isDeleting by rememberSaveable { mutableStateOf(false) }

    LargeTopAppBar(
        title = {
            Text(text = plan?.name.orEmpty())
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
            if (plan != null) {
                Box {
                    IconButton(onClick = { isMenuOpen = true }) {
                        Icon(imageVector = Icons.Rounded.MoreHoriz, contentDescription = null)
                    }
                    PlanMenu(
                        expanded = isMenuOpen,
                        onDismiss = { isMenuOpen = false },
                        onChangeName = { isEditing = true },
                        onDeletePlan = { isDeleting = true }
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior
    )

    if (plan != null && isEditing) {
        EditPlanModal(plan = plan, onDismiss = { isEditing = false }, onSave = onEditPlan)
    }

    if (plan != null && isDeleting) {
        ConfirmPlanDeletionDialog(
            onDismiss = { isDeleting = false },
            onConfirm = { onDeletePlan(plan.id) }
        )
    }
}