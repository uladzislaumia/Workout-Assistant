package com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.exercise_list.content

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.vladislavmyasnikov.common.arch_components.Packet
import com.vladislavmyasnikov.common.arch_components.SharedBus
import com.vladislavmyasnikov.common.interfaces.OnItemClickCallback
import com.vladislavmyasnikov.common.presentation.view.components.VMListFragment
import com.vladislavmyasnikov.feature_exercise_library_impl.domain.ShortExerciseInfo
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.adapters.ExerciseAdapter
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.viewmodels.ExerciseListVM
import javax.inject.Inject

class ExerciseListContent @Inject constructor(
        override val bus: SharedBus,
        override val adapter: ExerciseAdapter,
        override val viewModelFactory: ViewModelProvider.Factory
) : VMListFragment<ShortExerciseInfo>() {

    override val label = "EXERCISE_LIST_CF"

    override val viewModel: ExerciseListVM by lazy {
        ViewModelProvider(this, viewModelFactory).get(ExerciseListVM::class.java)
    }

    override val itemClickCallback = object : OnItemClickCallback {
        override fun onClick(id: Long, title: String) {
            bus.sendPacket(Packet.ItemClickMessage(id))
        }
    }

    override val itemClickCallbackInSelectMode: OnItemClickCallback? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetch()
    }
}