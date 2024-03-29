package com.vladislavmyasnikov.workout_library_and_player_impl.presentation.workout_library.workout_details.content

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.vladislavmyasnikov.common.arch.communication.Message
import com.vladislavmyasnikov.common.arch.communication.MessageSender
import com.vladislavmyasnikov.common.arch.communication.Messages
import com.vladislavmyasnikov.common.arch.component.VMHeaderFragment
import com.vladislavmyasnikov.common.extensions.injectViewModel
import com.vladislavmyasnikov.workout_library_and_player_impl.R
import com.vladislavmyasnikov.workout_library_and_player_impl.domain.entity.workout.Workout
import com.vladislavmyasnikov.workout_library_and_player_impl.presentation.workout_library.workout_details.viewmodel.WorkoutVM
import kotlinx.android.synthetic.main.content_workout_banner.*
import javax.inject.Inject

class WorkoutHeaderContent @Inject constructor(
        override val viewModelFactory: ViewModelProvider.Factory
) : VMHeaderFragment<Workout>(R.layout.content_workout_banner) {

    override val viewModel by lazy { injectViewModel<WorkoutVM>(viewModelFactory) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        start_workout_button.setOnClickListener { sendMessage(Messages.TransitionRequestMessage) }
        sendMessage(Messages.KeyDataRequestMessage)
    }

    override fun onReceiveItem(item: Workout) {
        setTitle(item.title)
        requireContext().let { context ->
            val resID = context.resources.getIdentifier(item.avatarID, "drawable", context.packageName)
            workout_avatar.setImageDrawable(ContextCompat.getDrawable(context, resID))
        }
    }

    override fun onReceiveMessage(message: Message, sender: MessageSender) {
        if (message is Messages.KeyDataResponseMessage) { viewModel.request(message.id) }
    }
}