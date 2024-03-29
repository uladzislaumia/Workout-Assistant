package com.vladislavmyasnikov.workout_library_and_player_impl.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vladislavmyasnikov.workout_library_and_player_impl.data.db.converter.DateTimeConverter
import com.vladislavmyasnikov.workout_library_and_player_impl.data.db.converter.ListConverter
import com.vladislavmyasnikov.workout_library_and_player_impl.data.db.dao.WorkoutLibraryDao
import com.vladislavmyasnikov.workout_library_and_player_impl.data.db.entity.CompletedWorkoutEntity
import com.vladislavmyasnikov.workout_library_and_player_impl.data.db.entity.WorkoutEntity
import com.vladislavmyasnikov.workout_library_and_player_impl.data.db.entity.WorkoutExerciseEntity
import com.vladislavmyasnikov.workout_library_and_player_impl.data.db.entity.WorkoutSetEntity

@Database(entities = [WorkoutExerciseEntity::class, WorkoutSetEntity::class, WorkoutEntity::class, CompletedWorkoutEntity::class], version = 1, exportSchema = false)
@TypeConverters(value = [ListConverter::class, DateTimeConverter::class])
abstract class LocalDatabase : RoomDatabase() {

    abstract fun workoutLibraryDao(): WorkoutLibraryDao
}