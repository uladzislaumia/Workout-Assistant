package com.vladislavmyasnikov.feature_workout_library_impl.domain.usecase.workout_list

import com.vladislavmyasnikov.feature_workout_library_impl.domain.model.ShortWorkout
import com.vladislavmyasnikov.feature_workout_library_impl.domain.repository.WorkoutRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetWorkoutListUCImpl @Inject constructor(
        private val workoutRepository: WorkoutRepository
) : GetWorkoutListUC {

    override fun invoke(): Observable<List<ShortWorkout>> = workoutRepository.fetchShortWorkoutList()
}