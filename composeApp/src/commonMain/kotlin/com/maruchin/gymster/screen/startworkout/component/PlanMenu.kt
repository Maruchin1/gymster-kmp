package com.maruchin.gymster.screen.startworkout.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun PlanMenu(
    expanded: Boolean,
    onDismiss: () -> Unit,
    onAddWorkout: () -> Unit,
    onDeletePlan: () -> Unit,
    onRenamePlan: () -> Unit,
    modifier: Modifier = Modifier
) {
    DropdownMenu(expanded = expanded, onDismissRequest = onDismiss, modifier = modifier) {
        DropdownMenuItem(
            text = {
                Text(text = "Add workout")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            onClick = {
                onAddWorkout()
                onDismiss()
            }
        )
        DropdownMenuItem(
            text = {
                Text(text = "Rename plan")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Edit,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            onClick = {
                onRenamePlan()
                onDismiss()
            }
        )
        DropdownMenuItem(
            text = {
                Text(text = "Delete plan")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error
                )
            },
            onClick = {
                onDeletePlan()
                onDismiss()
            }
        )
    }
}
