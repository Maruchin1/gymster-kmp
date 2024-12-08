package com.maruchin.gymster.data.plans2.model

import com.maruchin.gymster.data.exercises.model.ExerciseBase

internal data class ExerciseTemplate(
    val id: Int,
    val exerciseBase: ExerciseBase,
    val sets: List<SetTemplate>
)
