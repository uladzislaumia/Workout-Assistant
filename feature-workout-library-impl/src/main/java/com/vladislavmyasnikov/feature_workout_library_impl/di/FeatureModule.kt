package com.vladislavmyasnikov.feature_workout_library_impl.di

import com.vladislavmyasnikov.common.di.annotations.PerFeature
import com.vladislavmyasnikov.common.di.modules.LocalNavigationModule
import com.vladislavmyasnikov.feature_workout_library_impl.data.repo_mapper_impl.WorkoutRepositoryImpl
import com.vladislavmyasnikov.feature_workout_library_impl.domain.WorkoutRepository
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.view.WorkoutLibraryFeatureFlow
import com.vladislavmyasnikov.features_api.workout_library.WorkoutLibraryLauncher
import dagger.Binds
import dagger.Module

@Module(includes = [DatabaseModule::class, LocalNavigationModule::class, DependencyModule::class])
abstract class FeatureModule {

    @Binds @PerFeature
    abstract fun bind1(impl: WorkoutLibraryFeatureFlow): WorkoutLibraryLauncher

    @Binds @PerFeature
    abstract fun bind2(impl: WorkoutRepositoryImpl): WorkoutRepository
}