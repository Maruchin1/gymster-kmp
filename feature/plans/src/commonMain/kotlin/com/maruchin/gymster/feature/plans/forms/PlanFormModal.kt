package com.maruchin.gymster.feature.plans.forms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.plans.model.Plan
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PlanFormModal(plan: Plan?, onDismiss: () -> Unit, onSave: (name: String) -> Unit) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    ModalBottomSheet(onDismissRequest = onDismiss, sheetState = sheetState) {
        PlanFormContent(
            plan = plan,
            onSave = {
                scope.launch {
                    onSave(it)
                    sheetState.hide()
                    onDismiss()
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PlanFormContent(plan: Plan?, onSave: (name: String) -> Unit) {
    var planName by remember(plan) { mutableStateOf(plan?.name.orEmpty()) }

    Column {
        TopAppBar(
            title = {
                Text("Plan")
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = BottomSheetDefaults.ContainerColor
            ),
            windowInsets = WindowInsets(0)
        )
        OutlinedTextField(
            value = planName,
            onValueChange = { planName = it },
            label = {
                Text("Plan name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp)
        )
        Button(
            onClick = { onSave(planName) },
            enabled = planName.isNotBlank(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Save")
        }
    }
}
