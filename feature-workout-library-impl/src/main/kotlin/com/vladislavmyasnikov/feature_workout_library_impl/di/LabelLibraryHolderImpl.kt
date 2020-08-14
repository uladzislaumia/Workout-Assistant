package com.vladislavmyasnikov.feature_workout_library_impl.di

import com.vladislavmyasnikov.common.interfaces.LabelLibraryHolder
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.WorkoutDiaryFlow
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.WorkoutLibraryFlow
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.completed_workout_details.content.CompletedWorkoutContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.completed_workout_details.content.CompletedWorkoutToolbarContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.completed_workout_details.host.CompletedWorkoutScreenHost
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.completed_workout_details.viewmodel.CompletedWorkoutVM
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.completed_workout_list.content.CompletedWorkoutListContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.completed_workout_list.content.CompletedWorkoutListToolbarContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.completed_workout_list.host.CompletedWorkoutListScreenHost
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.completed_workout_list.viewmodel.CompletedWorkoutListVM
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_details.dialog.WorkoutExerciseDetailsDialog
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_details.content.WorkoutExerciseListConfigContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_details.content.WorkoutExerciseListContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_details.content.WorkoutHeaderContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_details.host.WorkoutScreenHost
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_details.host.WorkoutSetHost
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_list.content.WorkoutListContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_list.content.WorkoutListToolbarContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_list.host.WorkoutListScreenHost
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_player.content.ControlPanelContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_player.content.WorkoutExerciseMetricsContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_player.content.WorkoutExerciseConfigContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_player.content.WorkoutExerciseContent
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_player.host.WorkoutPlayerScreenHost
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_player.viewmodel.WorkoutPlayerVM
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_details.viewmodel.WorkoutExerciseListVM
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_details.viewmodel.WorkoutSetConfigVM
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_details.viewmodel.WorkoutVM
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_list.viewmodel.WorkoutListVM
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_player.viewmodel.WorkoutExerciseMetricsVM
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_player.viewmodel.WorkoutExerciseConfigVM
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_player.viewmodel.WorkoutExerciseVM
import kotlin.reflect.KClass

object LabelLibraryHolderImpl : LabelLibraryHolder {

    override val labels = listOf<Pair<KClass<*>, String>>(
            // content fragments
            WorkoutListContent::class to "WORKOUT_LIST_CONTENT",
            WorkoutListToolbarContent::class to "WORKOUT_LIST_TOOLBAR_CONTENT",
            WorkoutExerciseListConfigContent::class to "WORKOUT_SET_CONFIG_CONTENT",
            WorkoutExerciseListContent::class to "WORKOUT_EXERCISE_LIST_CONTENT",
            WorkoutHeaderContent::class to "WORKOUT_HEADER_CONTENT",
            ControlPanelContent::class to "CONTROL_PANEL_CONTENT",
            WorkoutExerciseMetricsContent::class to "WORKOUT_APPROACH_DATA_CONTENT",
            WorkoutExerciseConfigContent::class to "WORKOUT_EXERCISE_CONFIG_CONTENT",
            WorkoutExerciseContent::class to "WORKOUT_EXERCISE_CONTENT",
            CompletedWorkoutContent::class to "COMPLETED_WORKOUT_CONTENT",
            CompletedWorkoutToolbarContent::class to "COMPLETED_WORKOUT_TOOLBAR_CONTENT",
            CompletedWorkoutListContent::class to "COMPLETED_WORKOUT_LIST_CONTENT",
            CompletedWorkoutListToolbarContent::class to "COMPLETED_WORKOUT_LIST_TOOLBAR_CONTENT",

            // host fragments
            WorkoutListScreenHost::class to "WORKOUT_LIST_SCREEN_HOST",
            WorkoutScreenHost::class to "WORKOUT_DETAILS_SCREEN_HOST",
            WorkoutPlayerScreenHost::class to "WORKOUT_PLAYER_SCREEN_HOST",
            CompletedWorkoutListScreenHost::class to "COMPLETED_WORKOUT_LIST_SCREEN_HOST",
            CompletedWorkoutScreenHost::class to "COMPLETED_WORKOUT_DETAILS_SCREEN_HOST",
            WorkoutSetHost::class to "WORKOUT_SET_HOST",

            // flow fragments
            WorkoutLibraryFlow::class to "WORKOUT_LIBRARY_FLOW",
            WorkoutDiaryFlow::class to "WORKOUT_DIARY_FLOW",

            // dialogs
            WorkoutExerciseDetailsDialog::class to "WORKOUT_EXERCISE_DIALOG",

            // view models
            WorkoutListVM::class to "WORKOUT_LIST_VM",
            WorkoutExerciseListVM::class to "WORKOUT_EXERCISE_LIST_VM",
            WorkoutVM::class to "WORKOUT_VM",
            WorkoutExerciseVM::class to "WORKOUT_EXERCISE_VM",
            WorkoutPlayerVM::class to "WORKOUT_PLAYER_VM",
            WorkoutExerciseMetricsVM::class to "WORKOUT_EXERCISE_APPROACH_DATA_VM",
            WorkoutExerciseConfigVM::class to "WORKOUT_EXERCISE_CONFIG_VM",
            WorkoutSetConfigVM::class to "WORKOUT_SET_CONFIG_VM",
            CompletedWorkoutVM::class to "COMPLETED_WORKOUT_VM",
            CompletedWorkoutListVM::class to "COMPLETED_WORKOUT_LIST_VM"
    )
}