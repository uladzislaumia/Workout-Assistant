package com.vladislavmyasnikov.feature_exercise_library_impl.domain

class FullExerciseInfo(
        _id: Long,
        _title: String,
        _muscleGroupsIDs: List<Int>,
        _avatarID: String,
        val imagesIDs: List<String>,
        val description: String
) : ShortExerciseInfo(_id, _title, _muscleGroupsIDs, _avatarID)