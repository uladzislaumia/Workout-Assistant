package com.vladislavmyasnikov.workout_library_and_player_impl.presentation

import androidx.fragment.app.Fragment
import com.vladislavmyasnikov.common.arch.SharedBus
import com.vladislavmyasnikov.common.arch.fundamental.FlowFragment
import com.vladislavmyasnikov.workout_library_and_player_api.WorkoutLibraryLauncher
import com.vladislavmyasnikov.workout_library_and_player_impl.di.component.WorkoutLibraryFeatureComponent
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class WorkoutLibraryFlow @Inject constructor() : FlowFragment(), WorkoutLibraryLauncher {

    @Inject
    override lateinit var navigatorHolder: NavigatorHolder

    @Inject
    override lateinit var router: Router

    @Inject
    override lateinit var bus: SharedBus

    override fun inject() {
        super.inject()
        WorkoutLibraryFeatureComponent.get().inject(this)
        fragmentManager?.fragmentFactory = WorkoutLibraryFeatureComponent.get().fragmentFactory
    }

    override fun onStartUp() {
        super.onStartUp()
        router.newRootScreen(Screens.WorkoutListScreen())
    }

    override fun launch(): Fragment {
        return this
    }
}