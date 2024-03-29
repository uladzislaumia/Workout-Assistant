package com.vladislavmyasnikov.exercise_library_impl.domain.entity

data class Exercise(
        val id: Long,
        val title: String,
        val muscleGroupsIDs: List<Int>,
        val avatarID: String,
        val imagesIDs: List<String>,
        val description: String
)