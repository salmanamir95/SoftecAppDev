package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DailyPlannerViewModel : ViewModel() {
    private val _tasks = MutableLiveData<List<DailyPlannerTask>>(mutableListOf())
    val tasks: LiveData<List<DailyPlannerTask>> = _tasks

    // Add task
    fun addTask(task: DailyPlannerTask) {
        val updatedTasks = _tasks.value?.toMutableList() ?: mutableListOf()
        updatedTasks.add(task)
        _tasks.value = updatedTasks
    }

    // Filter tasks based on the selected date
    fun filterTasksByDate(date: String) {
        val filteredTasks = _tasks.value?.filter { it.date == date } ?: emptyList() // Use emptyList() if null
        _tasks.value = filteredTasks
    }
}
