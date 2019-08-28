package com.vladislavmyasnikov.feature_workout_library_impl.domain

import com.vladislavmyasnikov.core_utils.utils.interfaces.Identifiable

class SetInfo(
        val id: Long,
        val exercises: List<ExerciseInfo>
) : Identifiable<SetInfo> {

    override fun isIdentical(another: SetInfo): Boolean = id == another.id
}