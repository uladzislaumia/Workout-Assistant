package com.vladislavmyasnikov.workout_library_and_player_impl.presentation.workout_details.content

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.vladislavmyasnikov.common.arch.communication.Message
import com.vladislavmyasnikov.common.arch.communication.RequestMessageType
import com.vladislavmyasnikov.common.extensions.injectViewModel
import com.vladislavmyasnikov.common.arch.communication.MessageSender
import com.vladislavmyasnikov.common.interfaces.OnItemClickCallback
import com.vladislavmyasnikov.common.arch.component.VMListFragment
import com.vladislavmyasnikov.workout_library_and_player_impl.domain.entity.WorkoutExercise
import com.vladislavmyasnikov.workout_library_and_player_impl.presentation.workout_details.adapter.WorkoutExerciseAdapter
import com.vladislavmyasnikov.workout_library_and_player_impl.presentation.workout_details.viewmodel.WorkoutExerciseListVM
import javax.inject.Inject

class WorkoutExerciseListContent @Inject constructor(
        override val adapter: WorkoutExerciseAdapter,
        override val viewModelFactory: ViewModelProvider.Factory
) : VMListFragment<WorkoutExercise>() {

    override val viewModel by lazy { injectViewModel<WorkoutExerciseListVM>(viewModelFactory) }

    override val itemClickCallback = OnItemClickCallback { id: Long, _: String -> sendMessage(Message.ItemClickMessage(id)) }

    override val itemClickCallbackInSelectMode: OnItemClickCallback? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendMessage(Message.RequestMessage(RequestMessageType.KEY_DATA_REQUEST))
    }

    override fun onReceiveMessage(message: Message, sender: MessageSender) {
        if (message is Message.KeyDataResponseMessage) { viewModel.request(message.id) }
    }
}