package com.vladislavmyasnikov.feature_workout_library_impl.domain.model

data class WorkoutSetConfig(
        val setIndex: Int,
        val approach: Int,
        val setAmount: Int,
        val approachAmount: Int
)