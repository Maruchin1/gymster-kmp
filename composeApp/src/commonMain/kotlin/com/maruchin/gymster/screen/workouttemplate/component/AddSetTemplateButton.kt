package com.maruchin.gymster.screen.workouttemplate.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maruchin.gymster.data.plans2.model.AddSetTemplateRequest
import com.maruchin.gymster.data.plans2.model.ExerciseTemplate

@Composable
internal fun AddSetTemplateButton(
    exerciseTemplate: ExerciseTemplate,
    onClick: (AddSetTemplateRequest) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = {
            val request = AddSetTemplateRequest(
                exerciseTemplateId = exerciseTemplate.id,
                exerciseBaseId = exerciseTemplate.exerciseBase.id
            )
            onClick(request)
        },
        modifier = Modifier.fillMaxWidth().then(modifier)
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
        Text(text = "Add Set")
    }
}
