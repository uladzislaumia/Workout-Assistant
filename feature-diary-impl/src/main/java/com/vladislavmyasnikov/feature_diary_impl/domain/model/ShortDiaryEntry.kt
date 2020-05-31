package com.vladislavmyasnikov.feature_diary_impl.domain.model

import com.vladislavmyasnikov.common.models.TimePoint
import com.vladislavmyasnikov.common.interfaces.Identifiable
import java.util.*

data class ShortDiaryEntry(
        override val id: Long,
        val date: Date,
        val startTime: TimePoint,
        val endTime: TimePoint,
        val duration: TimePoint
) : Identifiable<ShortDiaryEntry> {

    override fun isIdentical(another: ShortDiaryEntry): Boolean = id == another.id
}