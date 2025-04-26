package com.example.personalizedailifeassistant.PersonalizedDashboard.Mood

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class MoodFragment : Fragment() {

    private lateinit var moodHistoryAdapter: MoodHistoryAdapter
    private val moodList = mutableListOf<String>() // Stores mood history

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mood, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvMood = view.findViewById<TextView>(R.id.tvMood)
        val btnHappy = view.findViewById<Button>(R.id.btnHappy)
        val btnSad = view.findViewById<Button>(R.id.btnSad)
        val btnStressed = view.findViewById<Button>(R.id.btnStressed)
        val btnRelaxed = view.findViewById<Button>(R.id.btnRelaxed)
        val btnAddMood = view.findViewById<Button>(R.id.btnAddMood)
        val recyclerViewMoodHistory = view.findViewById<RecyclerView>(R.id.recyclerViewMoodHistory)

        // Set up RecyclerView for mood history
        recyclerViewMoodHistory.layoutManager = LinearLayoutManager(requireContext())
        moodHistoryAdapter = MoodHistoryAdapter(moodList)
        recyclerViewMoodHistory.adapter = moodHistoryAdapter

        // Listen for mood selections
        btnHappy.setOnClickListener {
            tvMood.text = "Feeling Happy"
        }
        btnSad.setOnClickListener {
            tvMood.text = "Feeling Sad"
        }
        btnStressed.setOnClickListener {
            tvMood.text = "Feeling Stressed"
        }
        btnRelaxed.setOnClickListener {
            tvMood.text = "Feeling Relaxed"
        }

        // Add the selected mood to history when the button is clicked
        btnAddMood.setOnClickListener {
            val selectedMood = tvMood.text.toString()
            if (selectedMood != "Current Mood") {
                // Add mood and time to history
                moodList.add("$selectedMood - ${System.currentTimeMillis()}")
                moodHistoryAdapter.notifyItemInserted(moodList.size - 1)
                tvMood.text = "Current Mood"  // Reset the text
            } else {
                Toast.makeText(requireContext(), "Please select a mood first", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
