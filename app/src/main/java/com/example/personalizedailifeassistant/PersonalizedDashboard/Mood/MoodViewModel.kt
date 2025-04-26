package com.example.personalizedailifeassistant.PersonalizedDashboard.Mood

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoodViewModel : ViewModel() {

    private val _currentMood = MutableLiveData<String>("None")
    val currentMood: LiveData<String> get() = _currentMood

    private val _moodHistory = MutableLiveData<List<MoodLog>>(emptyList())
    val moodHistory: LiveData<List<MoodLog>> get() = _moodHistory

    fun updateMood(mood: String) {
        _currentMood.value = mood
        val updatedList = _moodHistory.value.orEmpty().toMutableList()
        updatedList.add(0, MoodLog(mood, System.currentTimeMillis().toString()))
        _moodHistory.value = updatedList
    }
}
