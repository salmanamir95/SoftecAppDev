package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalendarSharedViewModel : ViewModel() {
    private val _selectedDate = MutableLiveData<String>()
    val selectedDate: LiveData<String> = _selectedDate

    fun setSelectedDate(date: String) {
        _selectedDate.value = date
    }
}
