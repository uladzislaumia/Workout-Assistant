package com.vladislavmyasnikov.sample_app.presentation.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vladislavmyasnikov.core_components.interfaces.OnBackPressedListener
import com.vladislavmyasnikov.core_components.interfaces.RouterHolder
import com.vladislavmyasnikov.sample_app.R
import com.vladislavmyasnikov.sample_app.presentation.Controller
import com.vladislavmyasnikov.sample_app.presentation.SampleApp
import com.vladislavmyasnikov.sample_app.presentation.Screens
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity(), RouterHolder {

    @Inject
    override lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private lateinit var navigator: Navigator
    private lateinit var toolbar: Toolbar

    private val bottomPanelListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem: MenuItem ->
        when (menuItem.itemId) {
            R.id.exercises_tab -> selectTab("exercises")
            R.id.diary_tab -> selectTab("diary")
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SampleApp.INSTANCE.appComponent.inject(this)
        navigator = SupportAppNavigator(this, supportFragmentManager, R.id.content_frame)
        setContentView(R.layout.activity_main)

        toolbar = findViewById<Toolbar>(R.id.toolbar).apply { title = "" }
        setSupportActionBar(toolbar)
        Controller.activity = this

        val bottomPanel = findViewById<BottomNavigationView>(R.id.bottom_panel)
        bottomPanel.setOnNavigationItemSelectedListener(bottomPanelListener)

        if (savedInstanceState == null) {
            bottomPanelListener.onNavigationItemSelected(bottomPanel.menu.getItem(0))
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        Controller.activity = null
    }

    override fun onBackPressed() {
        val fm = supportFragmentManager
        var currentFragment: Fragment? = null
        for (fragment in fm.fragments) {
            if (fragment.isVisible) {
                currentFragment = fragment
                break
            }
        }
        currentFragment?.let {
            if (currentFragment !is OnBackPressedListener || !currentFragment.onBackPressed()) {
                router.exit()
            }
        }
    }

    private fun selectTab(tag: String) {
        val fm = supportFragmentManager
        val newFragment = fm.findFragmentByTag(tag)
        var currentFragment: Fragment? = null

        for (fragment in fm.fragments) {
            if (fragment.isVisible) {
                currentFragment = fragment
                break
            }
        }

        if (currentFragment != null && newFragment != null && currentFragment == newFragment) return

        val transaction = fm.beginTransaction()
        if (newFragment == null) {
            val screen = when (tag) {
                "exercises" -> Screens.ExercisesScreen()
                "diary" -> Screens.DiaryScreen()
                else -> return
            }
            transaction.add(R.id.content_frame, screen.fragment, tag)
        }
        currentFragment?.let { transaction.hide(currentFragment) }
        newFragment?.let { transaction.show(newFragment) }
        transaction.commitNow()
    }

    companion object {
        private const val TAG = "MAIN_ACTIVITY"
    }
}