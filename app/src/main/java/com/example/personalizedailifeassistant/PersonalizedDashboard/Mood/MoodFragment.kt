package com.example.personalizedailifeassistant.PersonalizedDashboard.Mood

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.personalizedailifeassistant.R

class MoodFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var moodHistoryAdapter: MoodHistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mood, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewMoodHistory)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Set your adapter to populate the RecyclerView
        moodHistoryAdapter = MoodHistoryAdapter()  // Create an adapter for mood history
        recyclerView.adapter = moodHistoryAdapter

        // Populate your RecyclerView with data (for example, mood history)
        val moodHistoryList = listOf("Happy", "Sad", "Relaxed", "Excited")
        moodHistoryAdapter.submitList(moodHistoryList)
    }
}
