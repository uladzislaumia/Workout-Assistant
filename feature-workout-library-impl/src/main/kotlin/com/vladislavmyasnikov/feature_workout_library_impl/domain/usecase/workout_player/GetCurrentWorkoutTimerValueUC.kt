package com.vladislavmyasnikov.feature_workout_library_impl.domain.usecase.workout_player

import com.vladislavmyasnikov.feature_workout_library_impl.domain.entity.workout_execution.TimerValue
import io.reactivex.Observable

interface GetCurrentWorkoutTimerValueUC {

    fun getCurrentWorkoutTimerValue(): Observable<TimerValue>
}