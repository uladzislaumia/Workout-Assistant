package com.vladislavmyasnikov.common.presentation.view.components

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vladislavmyasnikov.common.R
import com.vladislavmyasnikov.common.interfaces.HasList
import com.vladislavmyasnikov.common.interfaces.Identifiable
import com.vladislavmyasnikov.common.interfaces.OnItemClickCallback
import com.vladislavmyasnikov.common.presentation.adapters.SelectableBaseAdapter
import com.vladislavmyasnikov.common.arch_components.fundamental.VMFragment

abstract class VMListFragment<T : Identifiable<T>> : VMFragment<List<T>>(R.layout.linear_recycler_view) {

    protected abstract val itemClickCallback: OnItemClickCallback?
    protected abstract val itemClickCallbackInSelectMode: OnItemClickCallback?
    protected abstract val adapter: SelectableBaseAdapter<T>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter
        adapter.callback = itemClickCallback
        adapter.callbackInSelectMode = itemClickCallbackInSelectMode
        if (!adapter.hasObservers()) adapter.setHasStableIds(true)
    }

    override fun onReceiveItem(item: List<T>) {
        adapter.setList(item)
    }
}


abstract class VMNewListFragment<T : Identifiable<T>, CONT : HasList<T>> : VMFragment<CONT>(R.layout.linear_recycler_view) {

    protected abstract val itemClickCallback: OnItemClickCallback?
    protected abstract val itemClickCallbackInSelectMode: OnItemClickCallback?
    protected abstract val adapter: SelectableBaseAdapter<T>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter
        adapter.callback = itemClickCallback
        adapter.callbackInSelectMode = itemClickCallbackInSelectMode
        if (!adapter.hasObservers()) adapter.setHasStableIds(true)
    }

    override fun onReceiveItem(item: CONT) {
        adapter.setList(item.list)
    }
}
