package com.maruchin.gymster.core.utils

internal fun <T> Collection<T>.updated(index: Int, function: (T) -> T) = mapIndexed { i, item ->
    if (i == index) function(item) else item
}

internal fun <T> Collection<T>.updated(predicate: (T) -> Boolean, function: (T) -> T) =
    map { item ->
        if (predicate(item)) function(item) else item
    }

internal fun <T> Collection<T>.removed(index: Int) = filterIndexed { i, _ -> i != index }

internal fun <T> Collection<T>.removed(predicate: (T) -> Boolean) = filterNot(predicate)

internal fun <T> Collection<T>.swap(fromIndex: Int, toIndex: Int): List<T> {
    val mutableList = toMutableList()
    mutableList.add(toIndex, mutableList.removeAt(fromIndex))
    return mutableList
}

internal fun <T> Set<T>.toggle(value: T): Set<T> =
    if (contains(value)) minus(value) else plus(value)
