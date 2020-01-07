package com.vladislavmyasnikov.feature_exercise_library_impl.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vladislavmyasnikov.feature_exercise_library_impl.data.db.entities.FullExerciseInfo
import com.vladislavmyasnikov.feature_exercise_library_impl.data.db.entities.ShortExerciseInfo
import com.vladislavmyasnikov.features_api.exercise_library.WorkoutExerciseInfo
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface ExerciseLibraryDao {

    @Query("SELECT id, title, muscle_groups_ids, avatar_id FROM exercise_library")
    fun loadShortExercisesInfo(): Observable<List<ShortExerciseInfo>>

    @Query("SELECT * FROM exercise_library WHERE id = :id")
    fun loadExerciseInfoById(id: Long): Single<FullExerciseInfo>

    @Query("SELECT id, title, avatar_id FROM exercise_library WHERE id IN (:ids)")
    fun loadExercisesInfo(ids: List<Long>): Single<List<WorkoutExerciseInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExercisesInfo(info: List<FullExerciseInfo>)
}