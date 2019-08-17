package com.vladislavmyasnikov.feature_exercise_book_impl.domain

class FullExerciseInfo(
        _id: Long,
        _title: String,
        _muscleGroupsIDs: List<Int>,
        val description: String
) : ShortExerciseInfo(_id, _title, _muscleGroupsIDs)