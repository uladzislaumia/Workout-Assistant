package com.vladislavmyasnikov.common.di.modules

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.vladislavmyasnikov.common.experimental.di.InjectFragmentFactory
import com.vladislavmyasnikov.common.experimental.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class FactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    abstract fun bindFragmentFactory(factory: InjectFragmentFactory): FragmentFactory
}