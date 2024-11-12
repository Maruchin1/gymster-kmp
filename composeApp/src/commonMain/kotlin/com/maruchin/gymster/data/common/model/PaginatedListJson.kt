package com.maruchin.gymster.data.common.model

import kotlinx.serialization.Serializable

@Serializable
internal data class PaginatedListJson<T>(val results: List<T>)
