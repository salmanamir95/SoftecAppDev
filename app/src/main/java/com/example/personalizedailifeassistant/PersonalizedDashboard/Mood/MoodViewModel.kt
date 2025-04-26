package com.example.personalizedailifeassistant.PersonalizedDashboard.Mood

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoodViewModel : ViewModel() {
    // LiveData for the current mood
    private val _currentMood = MutableLiveData<String>("Feeling good")
    val currentMood: LiveData<String> get() = _currentMood

    // LiveData for the mood history
    private val _moodHistory = MutableLiveData<MutableList<String>>(mutableListOf())
    val moodHistory: LiveData<MutableList<String>> get() = _moodHistory

    // Function to update the current mood
    fun updateMood(newMood: String) {
        _currentMood.value = newMood
        // Add the new mood to the history
        _moodHistory.value?.add(newMood)
        _moodHistory.value = _moodHistory.value // Trigger LiveData update
    }
}