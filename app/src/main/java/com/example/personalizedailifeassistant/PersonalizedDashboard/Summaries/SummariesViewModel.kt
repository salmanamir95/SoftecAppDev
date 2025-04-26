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

    // New method for generating the summary from the note content
    fun generateSummaryFromText(noteText: String): String {
        // Here, you would apply your logic to generate bullet points from the noteText
        val bulletPoints = noteText.split("\n") // Example: split by new lines for simplicity
        return bulletPoints.take(5).joinToString("\n") // Condensing to 5 bullet points or less
    }
}
