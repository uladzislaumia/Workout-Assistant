package com.vladislavmyasnikov.workout_library_and_player_impl.presentation.workout_creator.workout_set_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vladislavmyasnikov.common.arch.adapter.SelectableBaseAdapter
import com.vladislavmyasnikov.workout_library_and_player_impl.R
import com.vladislavmyasnikov.workout_library_and_player_impl.domain.entity.workout_creation.WorkoutSet
import com.vladislavmyasnikov.workout_library_and_player_impl.presentation.textOfCycles
import com.vladislavmyasnikov.workout_library_and_player_impl.presentation.textOfExercises
import kotlinx.android.synthetic.main.item_workout_set.view.*
import javax.inject.Inject

class WorkoutSetAdapter @Inject constructor() : SelectableBaseAdapter<WorkoutSet>() {

    override fun constructViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_workout_set, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectableBaseAdapter.ViewHolder<WorkoutSet>, position: Int) {
        (holder as ViewHolder).bind(currentItems[position])
    }

    class ViewHolder(view: View) : SelectableBaseAdapter.ViewHolder.NonSelectableViewHolder<WorkoutSet>(view) {

        override fun bind(item: WorkoutSet) {
            itemView.workout_set_exercises.text = item.textOfExercises()
            itemView.workout_set_cycles.text = item.textOfCycles()
        }
    }
}