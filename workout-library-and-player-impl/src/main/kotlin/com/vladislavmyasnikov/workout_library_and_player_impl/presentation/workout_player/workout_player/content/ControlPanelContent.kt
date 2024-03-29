package com.vladislavmyasnikov.workout_library_and_player_impl.presentation.workout_player.workout_player.content

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.vladislavmyasnikov.common.arch.communication.Message
import com.vladislavmyasnikov.common.arch.communication.MessageSender
import com.vladislavmyasnikov.common.arch.communication.Messages
import com.vladislavmyasnikov.common.arch.component.VMFragment
import com.vladislavmyasnikov.common.extensions.injectViewModel
import com.vladislavmyasnikov.workout_library_and_player_impl.R
import com.vladislavmyasnikov.workout_library_and_player_impl.domain.entity.workout_execution.WorkoutProcessState
import com.vladislavmyasnikov.workout_library_and_player_impl.presentation.workout_player.workout_player.viewmodel.WorkoutPlayerVM
import kotlinx.android.synthetic.main.content_control_panel.*
import javax.inject.Inject

class ControlPanelContent @Inject constructor(
        override val viewModelFactory: ViewModelProvider.Factory
) : VMFragment<WorkoutProcessState>(R.layout.content_control_panel) {

    override val viewModel by lazy { injectViewModel<WorkoutPlayerVM>(viewModelFactory) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        next_button.setOnClickListener { viewModel.next() }
        stop_button.setOnClickListener { viewModel.finish() }
        pause_button.setOnClickListener { viewModel.pause() }
        resume_button.setOnClickListener { viewModel.resume() }

        sendMessage(Messages.KeyDataRequestMessage)
    }

    override fun onReceiveItem(item: WorkoutProcessState) {
        when (item) {
            WorkoutProcessState.STARTED -> {
                resume_button.visibility = View.GONE
                pause_button.visibility = View.VISIBLE
            }
            WorkoutProcessState.PAUSED -> {
                resume_button.visibility = View.VISIBLE
                pause_button.visibility = View.GONE
            }
            WorkoutProcessState.SAVING_RESULT -> {
                // TODO: show progress indicator
                resume_button.visibility = View.GONE
                pause_button.visibility = View.GONE
                stop_button.visibility = View.GONE
                next_button.visibility = View.GONE
            }
            WorkoutProcessState.FINISHED -> {
                // TODO: show warning dialog
                sendMessage(Messages.TransitionRequestMessage)
            }
        }
    }

    override fun onReceiveMessage(message: Message, sender: MessageSender) {
        if (message is Messages.KeyDataResponseMessage) { viewModel.request(message.id) }
    }
}