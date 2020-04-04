package com.vladislavmyasnikov.sample_app.di

import com.vladislavmyasnikov.sample_app.presentation.Controller
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone

@Module
class MainActivityModule {

    private val mainCicerone = Cicerone.create()

    @Provides
    fun provideController() = Controller

    @Provides
    fun provideMainRouter() = mainCicerone.router

    @Provides
    fun provideMainNavigatorHolder() = mainCicerone.navigatorHolder
}