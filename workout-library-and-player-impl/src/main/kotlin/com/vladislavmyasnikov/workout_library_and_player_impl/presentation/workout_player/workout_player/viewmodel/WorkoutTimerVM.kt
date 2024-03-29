package com.vladislavmyasnikov.workout_library_and_player_impl.presentation.workout_player.workout_player.viewmodel

import com.vladislavmyasnikov.common.arch.viewmodel.SimpleVM
import com.vladislavmyasnikov.common.models.Either
import com.vladislavmyasnikov.workout_library_and_player_impl.domain.entity.workout_execution.TimerValue
import com.vladislavmyasnikov.workout_library_and_player_impl.domain.usecase.workout_player.GetCurrentWorkoutTimerValueUC
import io.reactivex.Completable
import javax.inject.Inject

class WorkoutTimerVM @Inject constructor(
        private val getCurrentWorkoutTimerValueUC: GetCurrentWorkoutTimerValueUC
) : SimpleVM<TimerValue>() {

    override fun processRequest(id: Long): Either<Boolean, Completable> {
        return Either.Right(initAsynchronousRequest(getCurrentWorkoutTimerValueUC.getCurrentWorkoutTimerValue()))
    }
}