package com.vladislavmyasnikov.feature_workout_library_impl.presentation.viewmodels

import com.vladislavmyasnikov.common.components.GeneralViewModel
import com.vladislavmyasnikov.common.utils.Logger
import com.vladislavmyasnikov.feature_workout_library_impl.domain.FullWorkoutInfo
import com.vladislavmyasnikov.feature_workout_library_impl.domain.WorkoutRepository
import io.reactivex.schedulers.Schedulers

class WorkoutViewModel(private val repository: WorkoutRepository) : GeneralViewModel<Int>() {

    var wasFirstFetchRequest = false
        private set

    lateinit var workoutInfo: FullWorkoutInfo
        private set

    fun fetchFullWorkoutInfo(id: Long) {
        Logger.debug(TAG, "WorkoutInfo fetching: REQUEST")
        if (!isLoading) {
            wasFirstFetchRequest = true
            progressEmitter.onNext(true)
            isLoading = true
            Logger.debug(TAG, "WorkoutInfo fetching: PROCESSING IS STARTED")

            disposables.add(repository.fetchFullWorkoutInfo(id)
                    .doFinally {
                        progressEmitter.onNext(false)
                        isLoading = false
                        Logger.debug(TAG, "WorkoutInfo fetching: PROCESSING IS COMPLETED")
                    }
                    .subscribeOn(Schedulers.io())
                    .subscribe({ item ->
                        workoutInfo = item
                        itemEmitter.onNext(LOADED_REQUEST_RESULT)
                        outputWorkoutInfo(item)
                        Logger.debug(TAG, "WorkoutInfo fetching: SUCCESS")
                    }, { error ->
                        errorEmitter.onNext(error)//(ExceptionMapper.map(error))
                        Logger.debug(TAG, "WorkoutInfo fetching: ERROR; Cause: $error")
                    })
            )
        }
    }

    private fun outputWorkoutInfo(info: FullWorkoutInfo) {
        Logger.debug(TAG, "workoutID${info.id}")
        for (set in info.sets) {
            for (exercise in set.exercises) {
                Logger.debug(TAG, "setID${set.id} exID${exercise.id} '${exercise.title}' reps=${exercise.reps}")
            }
        }
    }

    companion object {
        private const val TAG = "WORKOUT_VM"
    }
}