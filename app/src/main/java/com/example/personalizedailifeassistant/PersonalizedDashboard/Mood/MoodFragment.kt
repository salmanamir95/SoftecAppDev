package com.example.personalizedailifeassistant.PersonalizedDashboard.Mood
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class MoodFragment : Fragment() {

    private val moodViewModel: MoodViewModel by viewModels()

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

        // UI references
        val tvMood = view.findViewById<TextView>(R.id.tvMood)
        val btnAddMood = view.findViewById<Button>(R.id.btnAddMood)
        val btnHappy = view.findViewById<Button>(R.id.btnHappy)
        val btnSad = view.findViewById<Button>(R.id.btnSad)
        val btnStressed = view.findViewById<Button>(R.id.btnStressed)
        val btnRelaxed = view.findViewById<Button>(R.id.btnRelaxed)

        // RecyclerView setup
        recyclerView = view.findViewById(R.id.recyclerViewMoodHistory)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        moodHistoryAdapter = MoodHistoryAdapter(mutableListOf())
        recyclerView.adapter = moodHistoryAdapter

        // Observing LiveData from ViewModel
        moodViewModel.currentMood.observe(viewLifecycleOwner) { mood ->
            tvMood.text = "Current Mood: $mood"
        }

        moodViewModel.moodHistory.observe(viewLifecycleOwner) { history ->
            moodHistoryAdapter.updateMoodHistory(history)
        }

        // Mood button listeners
        val moodButtons = mapOf(
            btnHappy to "Happy",
            btnSad to "Sad",
            btnStressed to "Stressed",
            btnRelaxed to "Relaxed"
        )

        for ((button, mood) in moodButtons) {
            button.setOnClickListener {
                moodViewModel.updateMood(mood)
            }
        }

        // Add mood manually based on current display
        btnAddMood.setOnClickListener {
            val current = tvMood.text.toString().removePrefix("Current Mood: ").trim()
            moodViewModel.updateMood(current)
        }
    }
}
