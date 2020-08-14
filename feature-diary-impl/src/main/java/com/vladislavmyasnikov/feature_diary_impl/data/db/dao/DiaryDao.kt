package com.vladislavmyasnikov.feature_diary_impl.data.db.dao

import androidx.room.*
import com.vladislavmyasnikov.feature_diary_impl.data.db.entity.DiaryEntryEntity
import com.vladislavmyasnikov.feature_diary_impl.data.db.entity.ShortDiaryEntryEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface DiaryDao {

    @Query("SELECT id, date, duration, workout_productivity, workout_id FROM diary")
    fun loadAllEntries(): Observable<List<ShortDiaryEntryEntity>>

    @Query("SELECT * FROM diary WHERE id = :id")
    fun loadEntryById(id: Long): Single<DiaryEntryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntry(entry: DiaryEntryEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntries(entries: List<DiaryEntryEntity>)

    @Update
    fun updateEntry(entry: DiaryEntryEntity)

    @Query("DELETE FROM diary WHERE id IN (:ids)")
    fun deleteEntriesByIds(ids: List<Long>): Completable
}
