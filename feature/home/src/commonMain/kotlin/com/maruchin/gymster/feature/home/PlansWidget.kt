package com.maruchin.gymster.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.plans.model.Plan

@Composable
internal fun PlansWidget(
    activePlan: Plan?,
    onOpenPlans: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Active plan",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )
            if (activePlan != null) {
                TextButton(onClick = onOpenPlans) {
                    Text(text = "All plans")
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(12.dp)) {
                if (activePlan == null) {
                    NoActivePlanContent(onOpenPlans = onOpenPlans)
                }
            }
        }
    }
}

@Composable
private fun NoActivePlanContent(onOpenPlans: () -> Unit) {
    TextButton(onClick = onOpenPlans, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Choose a plan")
    }
}
