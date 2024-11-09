package com.maruchin.gymster.screen.planlist.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.plans.model.Plan

@Composable
internal fun PlanItem(plan: Plan, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.fillMaxWidth().then(modifier), onClick = onClick) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(12.dp)
        ) {
            Text(text = plan.name, style = MaterialTheme.typography.titleLarge)
            Text(
                text = "Created: ${plan.creationDate}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
