package com.example.personalizedailifeassistant.PersonalizedDashboard.Mood

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class MoodFragment : Fragment() {

    private val moodViewModel: MoodViewModel by viewModels() // ViewModel for mood

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

        val tvMood = view.findViewById<TextView>(R.id.tvMood)
        val btnAddMood = view.findViewById<Button>(R.id.btnAddMood)
        val btnHappy = view.findViewById<Button>(R.id.btnHappy)
        val btnSad = view.findViewById<Button>(R.id.btnSad)
        val btnStressed = view.findViewById<Button>(R.id.btnStressed)
        val btnRelaxed = view.findViewById<Button>(R.id.btnRelaxed)

        // Set up RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewMoodHistory)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        moodHistoryAdapter = MoodHistoryAdapter(mutableListOf())
        recyclerView.adapter = moodHistoryAdapter

        // Observe the LiveData for current mood
        moodViewModel.currentMood.observe(viewLifecycleOwner) { mood ->
            tvMood.text = "Current Mood: $mood" // Update the UI with current mood
        }

        // Observe the LiveData for mood history
        moodViewModel.moodHistory.observe(viewLifecycleOwner) { history ->
            moodHistoryAdapter.updateMoodHistory(history) // Update the RecyclerView with mood history
        }

        // Set button listeners to update the mood
        btnHappy.setOnClickListener { moodViewModel.updateMood("Happy") }
        btnSad.setOnClickListener { moodViewModel.updateMood("Sad") }
        btnStressed.setOnClickListener { moodViewModel.updateMood("Stressed") }
        btnRelaxed.setOnClickListener { moodViewModel.updateMood("Relaxed") }

        // Button to add mood (can also be used for manual mood update)
        btnAddMood.setOnClickListener {
            val newMood = tvMood.text.toString().removePrefix("Current Mood: ")
            moodViewModel.updateMood(newMood) // Update the mood in ViewModel
        }
    }
}