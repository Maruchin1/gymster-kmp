package com.maruchin.gymster.screen.startworkout.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.maruchin.gymster.data.plans2.model.Plan
import com.maruchin.gymster.data.plans2.model.RenamePlanRequest

@Composable
internal fun PlanHeader(
    plan: Plan,
    onRenamePlan: (RenamePlanRequest) -> Unit,
    onDeletePlan: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var isMenuOpen by rememberSaveable { mutableStateOf(false) }
    var isRenamingPlan by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth().then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = plan.name,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.weight(1f)
        )
        Box {
            IconButton(onClick = { isMenuOpen = true }) {
                Icon(
                    imageVector = Icons.Rounded.MoreHoriz,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            PlanMenu(
                expanded = isMenuOpen,
                onDismiss = { isMenuOpen = false },
                onRenamePlan = { isRenamingPlan = true },
                onDeletePlan = { onDeletePlan(plan.id) },
            )
        }
    }

    if (isRenamingPlan) {
        RenamePlanModal(
            plan = plan,
            onDismiss = { isRenamingPlan = false },
            onSave = onRenamePlan
        )
    }
}
