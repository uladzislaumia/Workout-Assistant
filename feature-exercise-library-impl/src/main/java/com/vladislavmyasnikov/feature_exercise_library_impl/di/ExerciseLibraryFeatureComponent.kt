package com.vladislavmyasnikov.feature_exercise_library_impl.di

import com.vladislavmyasnikov.common.di.annotations.PerFeature
import com.vladislavmyasnikov.common.di.modules.FactoryModule
import com.vladislavmyasnikov.common.interfaces.ContextHolder
import com.vladislavmyasnikov.common.interfaces.ScreenTitleController
import com.vladislavmyasnikov.common.models.SyncObject
import com.vladislavmyasnikov.feature_exercise_library_impl.presentation.view.FlowFragment
import com.vladislavmyasnikov.features_api.exercise_library.ExerciseLibraryFeatureApi
import dagger.Component

@Component(modules = [ExerciseLibraryFeatureModule::class, FactoryModule::class, FragmentBindingModule::class, AdapterModule::class, ViewModelBindingModule::class], dependencies = [ExerciseLibraryFeatureDependencies::class])
@PerFeature
abstract class ExerciseLibraryFeatureComponent : ExerciseLibraryFeatureApi {

    val exerciseScreenComponent = SyncObject { exerciseLibraryScreenComponent() }
    val exerciseListScreenComponent = SyncObject { exerciseLibraryScreenComponent() }

    abstract fun exerciseLibraryScreenComponent(): ExerciseLibraryScreenComponent

    abstract fun inject(fragment: FlowFragment)

    companion object {

        @Volatile
        private var featureComponent: ExerciseLibraryFeatureComponent? = null

        fun initAndGet(dependencies: ExerciseLibraryFeatureDependencies): ExerciseLibraryFeatureApi {
            return featureComponent ?: synchronized(ExerciseLibraryFeatureComponent::class.java) {
                featureComponent ?: DaggerExerciseLibraryFeatureComponent.builder()
                        .exerciseLibraryFeatureDependencies(dependencies)
                        .build()
                        .also { featureComponent = it }
            }
        }

        fun get(): ExerciseLibraryFeatureComponent = featureComponent ?: throw RuntimeException("You must call 'initAndGet' method")
    }
}

@Component(dependencies = [ContextHolder::class, ScreenTitleController::class])
@PerFeature
interface ExerciseLibraryFeatureDependenciesComponent : ExerciseLibraryFeatureDependencies