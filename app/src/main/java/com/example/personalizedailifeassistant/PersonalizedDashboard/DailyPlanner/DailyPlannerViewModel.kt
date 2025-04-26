package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DailyPlannerViewModel : ViewModel() {
    private val _tasks = MutableLiveData<List<DailyPlannerTask>>(emptyList())
    val tasks: LiveData<List<DailyPlannerTask>> = _tasks

    fun addTask(task: DailyPlannerTask) {
        _tasks.value = _tasks.value?.plus(task)
    }
}