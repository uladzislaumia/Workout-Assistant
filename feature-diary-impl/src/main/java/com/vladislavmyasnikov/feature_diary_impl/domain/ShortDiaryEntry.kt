package com.vladislavmyasnikov.feature_diary_impl.domain

import com.vladislavmyasnikov.core_components.models.TimePoint
import com.vladislavmyasnikov.core_utils.utils.interfaces.Identifiable
import java.sql.Time
import java.util.*

open class ShortDiaryEntry(
        val id: Long,
        var date: Date,
        var startTime: TimePoint,
        var endTime: TimePoint,
        var duration: TimePoint
) : Identifiable<ShortDiaryEntry> {

    override fun isIdentical(another: ShortDiaryEntry): Boolean = id == another.id
}