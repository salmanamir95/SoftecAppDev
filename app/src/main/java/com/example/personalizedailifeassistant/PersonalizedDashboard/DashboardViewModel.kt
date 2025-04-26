package com.example.personalizedailifeassistant.PersonalizedDashboard

import androidx.lifecycle.ViewModel

// ViewModel for Dashboard
class DashboardViewModel : ViewModel() {
    private val repository = DashboardRepository()

    val currentMood = repository.getCurrentMood()
    val upcomingDeadlines = repository.getUpcomingDeadlines()
    val recentTasks = repository.getRecentTasks()
    val activeReminders = repository.getActiveReminders()
}