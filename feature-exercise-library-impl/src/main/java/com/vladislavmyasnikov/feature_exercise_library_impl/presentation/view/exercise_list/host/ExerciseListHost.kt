package com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.exercise_list.host

import android.content.Context
import androidx.fragment.app.FragmentFactory
import com.vladislavmyasnikov.common.arch_components.Packet
import com.vladislavmyasnikov.common.arch_components.SharedBus
import com.vladislavmyasnikov.common.arch_components.fundamental.HostFragment
import com.vladislavmyasnikov.feature_exercise_library_impl.R
import com.vladislavmyasnikov.feature_exercise_library_impl.di.ExerciseLibraryFeatureComponent
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.Screens
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.exercise_list.content.ExerciseListContent
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.exercise_list.content.ExerciseListToolbarContent
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ExerciseListHost @Inject constructor(
        override val bus: SharedBus,
        override val router: Router
) : HostFragment(R.layout.two_fragment_container) {

    override val label = "EXERCISE_LIST_HF"

    override val children = listOf(
            R.id.header_container to ExerciseListToolbarContent::class.java,
            R.id.body_container to ExerciseListContent::class.java
    )

    override lateinit var fragmentFactory: FragmentFactory

    override fun onAttach(context: Context) {
        fragmentFactory = ExerciseLibraryFeatureComponent.get().exerciseListComponent.getValue().fragmentFactory
        super.onAttach(context)
    }

    override fun onBackPressed(): Boolean {
        ExerciseLibraryFeatureComponent.get().exerciseListComponent.resetValue()
        return super.onBackPressed()
    }

    override fun onReceivePacket(packet: Packet) {
        if (packet is Packet.ItemClickMessage) {
            router.navigateTo(Screens.ExerciseDetailsScreen())
            bus.sendPacket(Packet.ItemFetchRequest(packet.id))
        }
    }
}