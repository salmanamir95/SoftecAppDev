package com.example.personalizedailifeassistant.PersonalizedDashboard.Summaries

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.personalizedailifeassistant.R

class SummariesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_summaries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tvSummaries = view.findViewById<TextView>(R.id.tvSummaries)
        val btnAddSummary = view.findViewById<Button>(R.id.btnAddSummary)

        tvSummaries.text = "You completed 2 tasks today."

        btnAddSummary.setOnClickListener {
            tvSummaries.text = "Updated summary: 3 tasks completed, mood stable."
        }
    }
}