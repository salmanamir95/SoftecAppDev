package com.example.personalizedailifeassistant.PersonalizedDashboard.Schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScheduleViewModel : ViewModel() {

    private val _schedules = MutableLiveData<MutableList<Schedule>>(mutableListOf())
    val schedules: LiveData<MutableList<Schedule>> = _schedules

    fun addSchedule(title: String) {
        _schedules.value?.add(Schedule(title))
        _schedules.value = _schedules.value // trigger LiveData update
    }
}
