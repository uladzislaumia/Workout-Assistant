package com.vladislavmyasnikov.workout_diary_impl.presentation.completed_workout_list.content

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.vladislavmyasnikov.common.arch.communication.Messages
import com.vladislavmyasnikov.common.arch.component.VMListFragment
import com.vladislavmyasnikov.common.extensions.injectViewModel
import com.vladislavmyasnikov.common.interfaces.OnItemClickCallback
import com.vladislavmyasnikov.workout_diary_impl.presentation.completed_workout_list.adapter.CompletedWorkoutAdapter
import com.vladislavmyasnikov.workout_diary_impl.presentation.completed_workout_list.viewmodel.CompletedWorkoutListVM
import com.vladislavmyasnikov.workout_library_and_player_api.domain.entity.ShortCompletedWorkout
import javax.inject.Inject

class CompletedWorkoutListContent @Inject constructor(
        override val adapter: CompletedWorkoutAdapter,
        override val viewModelFactory: ViewModelProvider.Factory
): VMListFragment<ShortCompletedWorkout>() {

    override val viewModel by lazy { injectViewModel<CompletedWorkoutListVM>(viewModelFactory) }

    override val itemClickCallback = OnItemClickCallback { id: Long, _: String -> sendMessage(Messages.ItemClickMessage(id)) }

    override val itemClickCallbackInSelectMode = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.request()
    }
}