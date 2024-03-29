package com.vladislavmyasnikov.workout_library_and_player_impl.presentation.workout_library.workout_list.viewmodel

import com.vladislavmyasnikov.common.arch.viewmodel.SimpleVM
import com.vladislavmyasnikov.common.models.Either
import com.vladislavmyasnikov.workout_library_and_player_impl.domain.entity.workout.ShortWorkout
import com.vladislavmyasnikov.workout_library_and_player_impl.domain.usecase.workout_list.GetWorkoutListUC
import io.reactivex.Completable
import javax.inject.Inject

class WorkoutListVM @Inject constructor(
        private val getWorkoutListUC: GetWorkoutListUC
) : SimpleVM<List<ShortWorkout>>() {

    private var currentItem: List<ShortWorkout> = emptyList()

    override fun processRequest(id: Long): Either<Boolean, Completable> {
        return Either.Right(initAsynchronousRequest(getWorkoutListUC.getAllWorkouts()))
    }

    override fun onSuccessfulResponse(item: List<ShortWorkout>) {
        currentItem = item
    }
}