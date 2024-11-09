package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun AddExerciseButton(modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = {},
        modifier = Modifier.fillMaxWidth().then(modifier)
    ) {
        Text(text = "Add exercise")
    }
}
