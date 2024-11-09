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
internal fun TrainingMenu(
    expanded: Boolean,
    onDismiss: () -> Unit,
    onChangeName: () -> Unit,
    onDeleteTraining: () -> Unit,
    modifier: Modifier = Modifier
) {
    DropdownMenu(expanded = expanded, onDismissRequest = onDismiss, modifier = modifier) {
        DropdownMenuItem(
            text = { Text(text = "Change name") },
            leadingIcon = { Icon(imageVector = Icons.Rounded.Edit, contentDescription = null) },
            onClick = {
                onChangeName()
                onDismiss()
            }
        )
        DropdownMenuItem(
            text = { Text(text = "Delete training") },
            leadingIcon = { Icon(imageVector = Icons.Rounded.Delete, contentDescription = null) },
            onClick = {
                onDeleteTraining()
                onDismiss()
            }
        )
    }
}
