package com.maruchin.gymster.screen.profile.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maruchin.gymster.data.userprofile.model.UserProfile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProfileTopAppBar(
    userProfile: UserProfile?,
    scrollBehavior: TopAppBarScrollBehavior,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    LargeTopAppBar(
        title = {
            Text(text = userProfile?.username?.let { "Hi $it!" }.orEmpty())
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBackIos,
                    contentDescription = "Back"
                )
            }
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier
    )
}
