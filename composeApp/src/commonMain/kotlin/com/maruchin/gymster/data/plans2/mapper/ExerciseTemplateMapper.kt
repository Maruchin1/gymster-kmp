package com.maruchin.gymster.data.plans2.mapper

import com.maruchin.gymster.data.exercises.model.ExerciseBase
import com.maruchin.gymster.data.plans2.json.SetJson
import com.maruchin.gymster.data.plans2.model.ExerciseTemplate
import com.maruchin.gymster.data.plans2.model.SetTemplate

internal fun SetJson.toDomain(
    exerciseBase: ExerciseBase,
    sets: List<SetTemplate>
) = ExerciseTemplate(
    id = id,
    exerciseBase = exerciseBase,
    sets = sets
)
