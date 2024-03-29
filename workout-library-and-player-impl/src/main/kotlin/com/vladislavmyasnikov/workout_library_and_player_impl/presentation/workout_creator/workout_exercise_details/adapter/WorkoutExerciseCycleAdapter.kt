package com.vladislavmyasnikov.workout_library_and_player_impl.presentation.workout_creator.workout_exercise_details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vladislavmyasnikov.common.arch.adapter.SelectableBaseAdapter
import com.vladislavmyasnikov.workout_library_and_player_impl.R
import com.vladislavmyasnikov.workout_library_and_player_impl.domain.entity.workout_creation.WorkoutExerciseCycle
import com.vladislavmyasnikov.workout_library_and_player_impl.presentation.textOfRepsAndWeight
import kotlinx.android.synthetic.main.item_workout_exercise_cycle.view.*
import javax.inject.Inject

class WorkoutExerciseCycleAdapter @Inject constructor() : SelectableBaseAdapter<WorkoutExerciseCycle>() {

    override fun constructViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_workout_exercise_cycle, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : SelectableBaseAdapter.ViewHolder.NonSelectableViewHolder<WorkoutExerciseCycle>(view) {

        override fun bind(item: WorkoutExerciseCycle) {
            itemView.workout_exercise_cycle.text = item.textOfRepsAndWeight(item.id.toInt())
        }
    }
}