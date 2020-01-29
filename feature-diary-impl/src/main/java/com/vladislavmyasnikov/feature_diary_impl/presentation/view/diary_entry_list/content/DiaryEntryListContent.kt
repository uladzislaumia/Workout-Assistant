package com.vladislavmyasnikov.feature_diary_impl.presentation.view.diary_entry_list.content

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.vladislavmyasnikov.common.arch_components.Event
import com.vladislavmyasnikov.common.arch_components.Packet
import com.vladislavmyasnikov.common.arch_components.SharedBus
import com.vladislavmyasnikov.common.interfaces.OnItemClickCallback
import com.vladislavmyasnikov.common.presentation.view.components.VMListFragment
import com.vladislavmyasnikov.feature_diary_impl.domain.ShortDiaryEntry
import com.vladislavmyasnikov.feature_diary_impl.presentation.adapters.DiaryEntryAdapter
import com.vladislavmyasnikov.feature_diary_impl.presentation.viewmodels.DiaryEntryListVM
import javax.inject.Inject

class DiaryEntryListContent @Inject constructor(
        override val bus: SharedBus,
        override val adapter: DiaryEntryAdapter,
        override val viewModelFactory: ViewModelProvider.Factory
): VMListFragment<ShortDiaryEntry>() {

    override val label = "DIARY_ENTRY_LIST_CF"

    override lateinit var viewModel: DiaryEntryListVM

    override val itemClickCallback = object : OnItemClickCallback {
        override fun onClick(id: Long, title: String) {
            bus.sendPacket(Packet.ItemClickMessage(id))
        }
    }

    override val itemClickCallbackInSelectMode = object : OnItemClickCallback {
        override fun onClick(id: Long, title: String) {
            viewModel.select(id)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DiaryEntryListVM::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetch()
    }

    override fun onReceiveEvent(event: Event) {
        super.onReceiveEvent(event)
        when (event) {
            is Event.SelectionModeChangeEvent -> {
                debugMessage(event.toString())
                adapter.isSelectMode = event.isSelected
            }
        }
    }
}