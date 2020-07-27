package com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_details.content

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.vladislavmyasnikov.common.arch.Message
import com.vladislavmyasnikov.common.arch.RequestMessageType
import com.vladislavmyasnikov.common.arch.SharedBus
import com.vladislavmyasnikov.common.interfaces.MessageSender
import com.vladislavmyasnikov.common.interfaces.OnItemClickCallback
import com.vladislavmyasnikov.common.presentation.view.components.VMListFragment
import com.vladislavmyasnikov.feature_workout_library_impl.domain.model.WorkoutExercise
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_details.adapter.WorkoutExerciseAdapter
import com.vladislavmyasnikov.feature_workout_library_impl.presentation.workout_details.viewmodel.WorkoutExerciseListVM
import javax.inject.Inject

class WorkoutExerciseListContent @Inject constructor(
        override val bus: SharedBus,
        override val adapter: WorkoutExerciseAdapter,
        override val viewModelFactory: ViewModelProvider.Factory
) : VMListFragment<WorkoutExercise>() {

    override val viewModel: WorkoutExerciseListVM by lazy {
        ViewModelProvider(this, viewModelFactory).get(WorkoutExerciseListVM::class.java)
    }

    override val itemClickCallback = object : OnItemClickCallback {
        override fun onClick(id: Long, title: String) {
            sendMessage(Message.ItemClickMessage(id))
        }
    }

    override val itemClickCallbackInSelectMode: OnItemClickCallback? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            sendMessage(Message.RequestMessage(RequestMessageType.KEY_DATA_REQUEST))
        }
    }

    override fun receiveMessage(message: Message, sender: MessageSender) {
        if (message is Message.KeyDataResponseMessage) {
            viewModel.request(message.id)
        }
    }
}