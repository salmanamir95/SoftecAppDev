package com.example.personalizedailifeassistant.PersonalizedDashboard.Summaries


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SummaryViewModel : ViewModel() {

    private val _summaries = MutableLiveData<MutableList<Summary>>(mutableListOf())
    val summaries: LiveData<MutableList<Summary>> = _summaries

    fun addSummary(content: String) {
        _summaries.value?.add(Summary(content))
        _summaries.value = _summaries.value // Trigger LiveData to update RecyclerView
    }
}
