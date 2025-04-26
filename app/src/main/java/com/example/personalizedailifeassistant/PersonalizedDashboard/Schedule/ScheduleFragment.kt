package com.example.personalizedailifeassistant.PersonalizedDashboard.Schedule

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.personalizedailifeassistant.R

class ScheduleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tvSchedule = view.findViewById<TextView>(R.id.tvSchedule)
        val btnAddSchedule = view.findViewById<Button>(R.id.btnAddSchedule)

        tvSchedule.text = "Team meeting at 2 PM"

        btnAddSchedule.setOnClickListener {
            tvSchedule.text = "${tvSchedule.text}, call with client at 4 PM"
        }
    }
}