package com.maruchin.gymster.screen.home.component

import androidx.compose.foundation.layout.Arrangement
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
internal fun ActivePlanWidget(
    activePlan: Plan?,
    onOpenPlans: () -> Unit,
    onOpenPlan: (planId: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Active plan",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.weight(1f)
            )
            if (activePlan != null) {
                TextButton(onClick = onOpenPlans) {
                    Text(text = "All plans")
                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (activePlan == null) {
                    onOpenPlans()
                } else {
                    onOpenPlan(activePlan.id)
                }
            }
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                if (activePlan == null) {
                    NoActivePlanContent()
                } else {
                    ActivePlanContent(plan = activePlan)
                }
            }
        }
    }
}

@Composable
private fun ActivePlanContent(plan: Plan) {
    val trainingsCount = plan.trainings.size

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = plan.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "${trainingsCount}x / week"
            )
        }
    }
}

@Composable
private fun NoActivePlanContent() {
    Text(text = "Choose a plan", modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp))
}
