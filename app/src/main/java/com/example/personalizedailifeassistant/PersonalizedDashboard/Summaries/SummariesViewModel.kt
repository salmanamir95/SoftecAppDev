package com.example.personalizedailifeassistant.PersonalizedDashboard.Summaries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SummariesViewModel : ViewModel() {
    private val _summaries = MutableLiveData<List<SummaryModel>>(emptyList())
    val summaries: LiveData<List<SummaryModel>> = _summaries

    fun addSummary(summary: SummaryModel) {
        _summaries.value = _summaries.value?.plus(summary)
    }
}