package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun PlanMenu(
    expanded: Boolean,
    onDismiss: () -> Unit,
    onChangeName: () -> Unit,
    onDeletePlan: () -> Unit,
    modifier: Modifier = Modifier
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismiss,
        modifier = modifier
    ) {
        DropdownMenuItem(
            leadingIcon = {
                Icon(imageVector = Icons.Rounded.Edit, contentDescription = null)
            },
            text = {
                Text(text = "Change name")
            },
            onClick = {
                onChangeName()
                onDismiss()
            }
        )
        DropdownMenuItem(
            leadingIcon = {
                Icon(imageVector = Icons.Rounded.Delete, contentDescription = null)
            },
            text = {
                Text(text = "Delete plan")
            },
            onClick = {
                onDeletePlan()
                onDismiss()
            }
        )
    }
}
