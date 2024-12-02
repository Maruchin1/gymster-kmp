package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.trainings.model.AddTrainingRequest
import com.maruchin.gymster.data.trainings.model.Training
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun TrainingTabs(
    planId: Int,
    trainings: List<Training>,
    pagerState: PagerState,
    onAddTraining: (AddTrainingRequest) -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    var isAdding by rememberSaveable { mutableStateOf(false) }

    Column {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 0.dp,
            divider = {},
            modifier = modifier
        ) {
            trainings.forEachIndexed { index, training ->
                Tab(
                    selected = index == pagerState.currentPage,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = training.name)
                    }
                )
            }
            IconButton(onClick = { isAdding = true }) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
            }
        }
        HorizontalDivider()
    }

    if (isAdding) {
        AddTrainingModal(
            planId = planId,
            onDismiss = { isAdding = false },
            onSave = onAddTraining
        )
    }
}
