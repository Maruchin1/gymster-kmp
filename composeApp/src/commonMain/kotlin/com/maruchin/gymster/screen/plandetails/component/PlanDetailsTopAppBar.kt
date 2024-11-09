package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import com.maruchin.gymster.data.plans.model.Plan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PlanDetailsTopAppBar(
    plan: Plan?,
    scrollBehavior: TopAppBarScrollBehavior,
    onBack: () -> Unit
) {
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
        scrollBehavior = scrollBehavior
    )
}
