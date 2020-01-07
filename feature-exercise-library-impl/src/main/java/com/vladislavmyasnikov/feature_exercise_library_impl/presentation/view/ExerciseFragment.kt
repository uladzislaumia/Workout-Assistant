package com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.chip.Chip
import com.vladislavmyasnikov.common.components.GeneralViewModel
import com.vladislavmyasnikov.common.view.GeneralFragment
import com.vladislavmyasnikov.feature_exercise_library_impl.R
import com.vladislavmyasnikov.feature_exercise_library_impl.di.ExerciseLibraryFeatureComponent
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.adapters.ExerciseImagePagerAdapter
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.viewmodels.ExerciseViewModel
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_exercise.*
import javax.inject.Inject

class ExerciseFragment : GeneralFragment<ExerciseViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var adapter: ExerciseImagePagerAdapter

    private lateinit var muscleGroupNames: Array<String>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ExerciseLibraryFeatureComponent.get().exerciseScreenComponent.getValue().inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ExerciseViewModel::class.java)
        muscleGroupNames = context.resources.getStringArray(R.array.muscle_groups)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_exercise, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_pager.adapter = adapter

        if (!viewModel.wasFirstFetchRequest) {
            viewModel.fetchFullExerciseInfo(arguments!!.getLong(EXERCISE_ID_ARG))
        }
    }

    override fun <Int> onReceiveItem(item: Int) {
        when (item) {
            GeneralViewModel.LOADED_REQUEST_RESULT -> { updateContent() }
        }
    }

    override fun onBackPressed(): Boolean {
        ExerciseLibraryFeatureComponent.get().exerciseScreenComponent.resetValue()
        return super.onBackPressed()
    }

    override fun updateToolbar() {
        super.updateToolbar()
        screenTitleController.setTitle("")
        screenTitleController.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)
    }

    private fun updateContent() {
        val exerciseInfo = viewModel.exerciseInfo
        title_field.text = exerciseInfo.title
        description_field.text = exerciseInfo.description
        adapter.imagesIDs = exerciseInfo.imagesIDs

        for ((index, muscleGroupID) in exerciseInfo.muscleGroupsIDs.withIndex()) {
            val tag = Chip(context).apply {
                id = index
                text = muscleGroupNames[muscleGroupID]
            }
            muscle_groups_tags.addView(tag)
        }
    }

    companion object {
        private const val EXERCISE_ID_ARG = "exercise_id_arg"
        private const val TITLE_ARG = "title_arg"

        fun newInstance(id: Long, title: String): ExerciseFragment {
            return ExerciseFragment().apply {
                arguments = Bundle().apply {
                    putLong(EXERCISE_ID_ARG, id)
                    putString(TITLE_ARG, title)
                }
            }
        }
    }
}