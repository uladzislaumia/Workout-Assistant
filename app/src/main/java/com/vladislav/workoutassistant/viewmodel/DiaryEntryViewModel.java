package com.vladislav.workoutassistant.viewmodel;

import com.vladislav.workoutassistant.data.DiaryEntry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class DiaryEntryViewModel extends BaseObservable {

    private DiaryEntry mDiaryEntry;
    private DateFormat timeFormatter;
    private DateFormat dateFormatter;
    private DateFormat durationFormatter;

    public DiaryEntryViewModel() {
        dateFormatter = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
        timeFormatter = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault());
        durationFormatter = new SimpleDateFormat("HH:mm", Locale.getDefault());
        durationFormatter.setTimeZone(TimeZone.getTimeZone("GTM"));
    }

    @Bindable
    public String getId() {
        if (mDiaryEntry != null) {
            return Integer.toString(mDiaryEntry.getId());
        }
        return null;
    }

    @Bindable
    public String getTitle() {
        if (mDiaryEntry != null) {
            return mDiaryEntry.getTitle();
        }
        return null;
    }

    @Bindable
    public String getDate() {
        if (mDiaryEntry != null && mDiaryEntry.getDate() != null) {
            return dateFormatter.format(mDiaryEntry.getDate());
        }
        return null;
    }

    @Bindable
    public String getStartTime() {
        if (mDiaryEntry != null && mDiaryEntry.getStartTime() != null) {
            return timeFormatter.format(mDiaryEntry.getStartTime());
        }
        return null;
    }

    @Bindable
    public String getFinishTime() {
        if (mDiaryEntry != null && mDiaryEntry.getFinishTime() != null) {
            return timeFormatter.format(mDiaryEntry.getFinishTime());
        }
        return null;
    }

    @Bindable
    public String getDuration() {
        if (mDiaryEntry != null && mDiaryEntry.getDuration() != null) {
            return durationFormatter.format(mDiaryEntry.getDuration());
        }
        return null;
    }

    public DiaryEntry getDiaryEntry() {
        return mDiaryEntry;
    }

    public void setDiaryEntry(DiaryEntry diaryEntry) {
        mDiaryEntry = diaryEntry;
        notifyChange();
    }

    public void setDate(Date date) {
        mDiaryEntry.setDate(date);
        notifyChange();
    }

    public void setStartTime(Date time) {
        mDiaryEntry.setStartTime(time);
        notifyChange();
    }

    public void setFinishTime(Date time) {
        mDiaryEntry.setFinishTime(time);
        notifyChange();
    }

    public void setDuration(Date duration) {
        mDiaryEntry.setDuration(duration);
        notifyChange();
    }
}
