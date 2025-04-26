package com.example.personalizedailifeassistant.PersonalizedDashboard.Reminders
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class RemindersViewModel : ViewModel() {

    private val _reminders = MutableLiveData<MutableList<Reminder>>(mutableListOf())
    val reminders: LiveData<MutableList<Reminder>> = _reminders

    fun addReminder(title: String) {
        _reminders.value?.add(Reminder(title))
        _reminders.value = _reminders.value // trigger LiveData update
    }
}