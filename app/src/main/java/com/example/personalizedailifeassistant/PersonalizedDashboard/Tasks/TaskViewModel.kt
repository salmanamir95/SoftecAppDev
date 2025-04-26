package com.example.personalizedailifeassistant.PersonalizedDashboard.Tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TasksViewModel : ViewModel() {

    // Changed the list to hold Task objects instead of Strings
    private val _tasks = MutableLiveData<MutableList<Task>>(mutableListOf(
        Task("Complete project report", category = "Academic"),
        Task("Attend meeting", category = "Work")
    ))

    val tasks: LiveData<MutableList<Task>> = _tasks

    // Modify addTask to accept a Task object
    fun addTask(task: Task) {
        _tasks.value?.add(task)
        _tasks.value = _tasks.value // Force refresh LiveData
    }

    // Update the task list (to modify or refresh tasks)
    fun updateTasks(newTasks: List<Task>) {
        _tasks.value?.clear()  // Clear the current list before adding the new tasks
        _tasks.value?.addAll(newTasks) // Add the new tasks
        _tasks.value = _tasks.value // Force refresh LiveData
    }
}
