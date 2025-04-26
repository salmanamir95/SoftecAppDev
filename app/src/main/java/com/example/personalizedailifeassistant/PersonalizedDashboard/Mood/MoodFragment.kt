package com.example.personalizedailifeassistant.PersonalizedDashboard.Mood

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.personalizedailifeassistant.R

class MoodFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mood, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tvMood = view.findViewById<TextView>(R.id.tvMood)
        val btnAddMood = view.findViewById<Button>(R.id.btnAddMood)

        tvMood.text = "Feeling good"

        btnAddMood.setOnClickListener {
            tvMood.text = "Mood updated to: Relaxed"
        }
    }
}