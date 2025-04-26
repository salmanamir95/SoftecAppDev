package com.example.personalizedailifeassistant.PersonalizedDashboard.Tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TasksViewModel : ViewModel() {

    private val _tasks = MutableLiveData<MutableList<String>>(mutableListOf(
        "Complete project report", "Attend meeting"
    ))
    val tasks: LiveData<MutableList<String>> = _tasks

    fun addTask(task: String) {
        _tasks.value?.add(task)
        _tasks.value = _tasks.value // Force refresh LiveData
    }
}