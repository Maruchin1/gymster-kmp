package com.maruchin.gymster.screen.profile.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maruchin.gymster.data.userprofile.model.UserProfile

@Composable
internal fun EmailItem(userProfile: UserProfile, modifier: Modifier = Modifier) {
    ProfileItem(
        icon = Icons.Rounded.Email,
        title = "Email",
        value = userProfile.email,
        modifier = modifier
    )
}
