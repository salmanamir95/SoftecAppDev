package com.example.personalizedailifeassistant.PersonalizedDashboard.Schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScheduleViewModel : ViewModel() {
    private val _schedules = MutableLiveData<List<ScheduleModel>>(emptyList())
    val schedules: LiveData<List<ScheduleModel>> = _schedules

    fun addSchedule(schedule: ScheduleModel) {
        val updatedList = _schedules.value.orEmpty().toMutableList()
        updatedList.add(schedule)
        _schedules.value = updatedList
    }
}