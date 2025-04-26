package com.example.personalizedailifeassistant.PersonalizedDashboard.Tasks

data class Task(
    val title: String,
    val description: String = "",
    val dueDate: String = "",
    val priority: Int = 0,
    val category: String = ""  // This field will store the task's category
)
