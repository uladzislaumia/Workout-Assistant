package com.vladislavmyasnikov.common.arch.component

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import com.vladislavmyasnikov.common.R
import com.vladislavmyasnikov.common.arch.navigation.OnBackPressedListener
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen

abstract class FlowFragment : BaseFragment(R.layout.fragment_container), OnBackPressedListener {

    protected abstract val initialScreen: SupportAppScreen
    protected abstract val fragmentFactory: FragmentFactory
    protected abstract val router: Router
    protected abstract val navigatorHolder: NavigatorHolder
    private lateinit var navigator: Navigator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        childFragmentManager.fragmentFactory = fragmentFactory
        navigator = SupportAppNavigator(requireActivity(), childFragmentManager, R.id.container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (childFragmentManager.findFragmentById(R.id.container) == null) router.newRootScreen(initialScreen)
//        if (savedInstanceState == null) router.newRootScreen(initialScreen)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed(): Boolean {
        val visibleChildFragment = childFragmentManager.findFragmentById(R.id.container)
        visibleChildFragment?.let {
            if (it is OnBackPressedListener) {
                val wasProcessed = it.onBackPressed()
                if (!wasProcessed) {
                    if (childFragmentManager.backStackEntryCount > 0) {
                        router.exit()
                        return true
                    }
                }
                return wasProcessed
            }
        }
        return false
    }
}