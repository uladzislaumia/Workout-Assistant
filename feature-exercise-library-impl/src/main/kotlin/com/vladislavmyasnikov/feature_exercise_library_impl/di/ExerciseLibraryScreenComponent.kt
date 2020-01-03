package com.vladislavmyasnikov.feature_exercise_library_impl.di

import com.vladislavmyasnikov.common.di.PerScreen
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.ExerciseFragment
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.ExerciseListFragment
import dagger.Subcomponent

@Subcomponent(modules = [AdapterModule::class])
@PerScreen
abstract class ExerciseLibraryScreenComponent {

    abstract fun inject(fragment: ExerciseFragment)
    abstract fun inject(fragment: ExerciseListFragment)
}