package com.vladislavmyasnikov.common.utils

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback<T : com.vladislavmyasnikov.common.interfaces.Identifiable<T>>(private val oldList: List<T>, private val newList: List<T>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].isIdentical(newList[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]
}