package com.example.personalizedailifeassistant.PersonalizedDashboard.Reminders

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.personalizedailifeassistant.R

class RemindersFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reminders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tvReminders = view.findViewById<TextView>(R.id.tvReminders)
        val btnAddReminder = view.findViewById<Button>(R.id.btnAddReminder)

        tvReminders.text = "Drink water every hour"

        btnAddReminder.setOnClickListener {
            tvReminders.text = "${tvReminders.text}, review notes at 9 PM"
        }
    }
}