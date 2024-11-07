package com.maruchin.gymster.screen.profile.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Logout
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
internal fun LogoutItem(onLogout: () -> Unit, modifier: Modifier = Modifier) {
    var confirmLogout by rememberSaveable { mutableStateOf(false) }

    ProfileItem(
        icon = Icons.AutoMirrored.Rounded.Logout,
        title = "Logout",
        onClick = { confirmLogout = true },
        modifier = modifier
    )

    if (confirmLogout) {
        AlertDialog(
            onDismissRequest = { confirmLogout = false },
            icon = {
                Icon(imageVector = Icons.AutoMirrored.Rounded.Logout, contentDescription = null)
            },
            title = {
                Text(text = "Logout")
            },
            text = {
                Text(text = "Are you sure you want to logout?")
            },
            confirmButton = {
                TextButton(onClick = onLogout) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { confirmLogout = false }) {
                    Text(text = "Cancel")
                }
            }
        )
    }
}
