package com.vladislavmyasnikov.feature_exercise_library_impl.di

import com.vladislavmyasnikov.common.interfaces.LabelLibraryHolder
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.ExerciseLibraryFeatureFlow
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.exercise.content.ExerciseContent
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.exercise.host.ExerciseScreenHost
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.exercise_list.content.ExerciseListContent
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.exercise_list.content.ExerciseListToolbarContent
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.exercise_list.host.ExerciseListScreenHost
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.viewmodel.ExerciseListVM
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.viewmodel.ExerciseVM
import kotlin.reflect.KClass

object LabelLibraryHolderImpl : LabelLibraryHolder {

    override val labels = listOf<Pair<KClass<*>, String>>(
            // content fragments
            ExerciseListContent::class to "EXERCISE_LIST_CONTENT",
            ExerciseListToolbarContent::class to "EXERCISE_LIST_TOOLBAR_CONTENT",
            ExerciseContent::class to "EXERCISE_CONTENT",

            // host fragments
            ExerciseListScreenHost::class to "EXERCISE_LIST_SCREEN_HOST",
            ExerciseScreenHost::class to "EXERCISE_DETAILS_SCREEN_HOST",

            // flow fragments
            ExerciseLibraryFeatureFlow::class to "EXERCISE_LIBRARY_FEATURE_FLOW",

            // dialogs

            // view models
            ExerciseListVM::class to "EXERCISE_LIST_VM",
            ExerciseVM::class to "EXERCISE_VM"
    )
}