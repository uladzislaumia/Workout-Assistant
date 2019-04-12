package com.vladislav.workoutassistant.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vladislav.workoutassistant.data.models.Identifiable
import com.vladislav.workoutassistant.data.models.Nameable

@Entity(tableName = "workouts")
data class Workout (@PrimaryKey(autoGenerate = true) override val id: Int = 0,
                    override var name: String,
                    @ColumnInfo(name = "category_id") val categoryId: Int,
                    @ColumnInfo(name = "intensity_level_id") val intensityLevelId: Int) : Identifiable, Nameable