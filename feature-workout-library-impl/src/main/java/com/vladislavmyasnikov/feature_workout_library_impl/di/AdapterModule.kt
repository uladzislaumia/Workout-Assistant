package com.vladislavmyasnikov.feature_workout_library_impl.di

import com.vladislavmyasnikov.common.di.annotations.PerScreen
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.adapters.WorkoutAdapter
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.adapters.WorkoutSetAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides @PerScreen
    fun provide1() = WorkoutAdapter()

    @Provides @PerScreen
    fun provide2() = WorkoutSetAdapter()
}