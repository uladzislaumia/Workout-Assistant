package com.vladislavmyasnikov.exercise_library_impl.domain.entity

import com.vladislavmyasnikov.common.interfaces.Identifiable

data class ShortExercise(
        override val id: Long,
        val title: String,
        val muscleGroupsIDs: List<Int>,
        val avatarID: String
) : Identifiable<ShortExercise> {

    override fun isIdentical(another: ShortExercise): Boolean = id == another.id
}