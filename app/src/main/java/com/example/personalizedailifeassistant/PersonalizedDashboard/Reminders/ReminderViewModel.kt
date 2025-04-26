package com.example.personalizedailifeassistant.PersonalizedDashboard.Reminders
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RemindersViewModel : ViewModel() {
    private val _reminders = MutableLiveData<MutableList<String>>(mutableListOf())
    val reminders: LiveData<MutableList<String>> = _reminders

    fun addReminder(reminder: String) {
        _reminders.value?.add(reminder)
        _reminders.value = _reminders.value  // force update
    }
}