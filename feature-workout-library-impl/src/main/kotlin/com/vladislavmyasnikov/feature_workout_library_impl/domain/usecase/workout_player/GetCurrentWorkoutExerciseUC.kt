package com.vladislavmyasnikov.feature_workout_library_impl.domain.usecase.workout_player

import com.vladislavmyasnikov.feature_workout_library_impl.domain.entity.WorkoutExercise
import io.reactivex.Observable

interface GetCurrentWorkoutExerciseUC {

    fun getCurrentWorkoutExercise(): Observable<WorkoutExercise>
}