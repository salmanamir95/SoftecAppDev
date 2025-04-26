package com.example.personalizedailifeassistant.PersonalizedDashboard

import androidx.lifecycle.MutableLiveData

class DashboardRepository {
    // Add actual repository implementation to fetch data from other ViewModels
    fun getCurrentMood() = MutableLiveData<String>("😊")
    fun getUpcomingDeadlines() = MutableLiveData<List<Any>>(emptyList())
    fun getRecentTasks() = MutableLiveData<List<Any>>(emptyList())
    fun getActiveReminders() = MutableLiveData<List<Any>>(emptyList())
}