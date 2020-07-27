package com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_player.viewmodel

import com.vladislavmyasnikov.common.arch.viewmodel.SimpleVM
import com.vladislavmyasnikov.common.models.Either
import com.vladislavmyasnikov.feature_workout_library_impl.domain.model.WorkoutExerciseConfig
import com.vladislavmyasnikov.feature_workout_library_impl.domain.usecase.workout_player.GetCurrentWorkoutExerciseConfigUC
import io.reactivex.Completable
import javax.inject.Inject

class WorkoutExerciseConfigVM @Inject constructor(
        private val getCurrentWorkoutExerciseConfigUC: GetCurrentWorkoutExerciseConfigUC
) : SimpleVM<WorkoutExerciseConfig>() {

    override fun processRequest(id: Long): Either<Boolean, Completable> {
        return Either.Right(initAsynchronousRequest(getCurrentWorkoutExerciseConfigUC.getCurrentWorkoutExerciseConfig()))
    }
}